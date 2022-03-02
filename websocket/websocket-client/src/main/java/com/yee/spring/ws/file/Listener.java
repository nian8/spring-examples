package com.yee.spring.ws.file;

public interface Listener {
    /**
     * 发生文件变动事件时的处理逻辑
     *
     * @param event
     */
    void fire(FileChangeEvent event);
}
