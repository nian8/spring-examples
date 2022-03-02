package com.yee.spring.ws.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class SendReq {

    public String cmd = "SEND_REQ";

    public Long seq;

    public Map<String, String> data;

    public static SendReq of(String key, String value) {
        SendReq sendReq = new SendReq();
        sendReq.setSeq(RandomUtils.nextLong());
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        sendReq.setData(map);
        return sendReq;
    }
}
