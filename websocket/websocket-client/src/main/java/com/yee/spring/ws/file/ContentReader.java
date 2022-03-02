package com.yee.spring.ws.file;

import com.yee.spring.ws.client.WebsocketService;
import com.yee.spring.ws.model.SendReq;
import org.apache.commons.io.input.ReversedLinesFileReader;
import org.apache.commons.lang3.RandomUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentReader {

    private final FileWrapper wrapper;

    private WebsocketService websocketService;

    public ContentReader(FileWrapper wrapper, WebsocketService websocketService) {
        this.wrapper = wrapper;
        this.websocketService = websocketService;
    }

    public void read() throws IOException {
        try (LineNumberReader lineReader = new LineNumberReader(new FileReader(wrapper.getFile()))) {
            lineReader.skip(Long.MAX_VALUE);
            int lineNum = lineReader.getLineNumber() / 2 + 1;
            //
            System.out.println(lineNum + "; " + wrapper.getCurrentLine());
            if (lineNum > wrapper.getCurrentLine()) {
                List<String> contents = readLastLine(wrapper.getFile(), (lineNum - wrapper.getCurrentLine()));
                Collections.reverse(contents);
                for (String content : contents) {
                    // 这里只是简单打印出新加的内容到控制台
//                    System.out.println(content);
                    //
                    SendReq sendReq = new SendReq();
                    sendReq.setSeq(RandomUtils.nextLong());
                    Map<String, String> map = new HashMap<>(16);
                    map.put("fileName", wrapper.getFile().getName());
                    map.put("content", content);
                    sendReq.setData(map);
                    websocketService.send(sendReq);
                }
            }
            // 保存当前读取到的行数
            wrapper.setCurrentLine(lineNum);
        }
    }

    public static List<String> readLastLine(File file, int numLastLineToRead) {
        List<String> result = new ArrayList<>();
        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(file, StandardCharsets.UTF_16LE)) {
            String line = "";
            while ((line = reader.readLine()) != null && result.size() < numLastLineToRead) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}
