package com.yee.spring.ws.file;

import com.yee.spring.ws.client.WebsocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FileChangeListener implements Listener {

    @Autowired
    private WebsocketService websocketService;

    /**
     * 保存路径跟文件包装类的映射
     */
    private final Map<String, FileWrapper> map = new ConcurrentHashMap<>();

    @Override
    public void fire(FileChangeEvent event) {
        switch (event.getKind().name()) {
            case "ENTRY_MODIFY":
                // 文件修改事件
                modify(event.getPath());
                break;
            default:
                throw new UnsupportedOperationException(
                        String.format("The kind [%s] is unsupport.", event.getKind().name()));
        }
    }

    private void modify(Path path) {
        // 根据全路径获取包装类对象
        FileWrapper wrapper = map.get(path.toString());
        if (wrapper == null) {
            wrapper = new FileWrapper(path.toFile());
            map.put(path.toString(), wrapper);
        }
        try {
            // 读取追加的内容
            new ContentReader(wrapper, websocketService).read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
