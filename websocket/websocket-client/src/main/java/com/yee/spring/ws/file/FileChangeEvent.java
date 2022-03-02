package com.yee.spring.ws.file;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

public class FileChangeEvent {
    /**
     * 文件全路径
     */
    private final Path path;
    /**
     * 事件类型
     */
    private final WatchEvent.Kind<?> kind;

    public FileChangeEvent(Path path, WatchEvent.Kind<?> kind) {
        this.path = path;
        this.kind = kind;
    }

    public Path getPath() {
        return this.path;
    }

    public WatchEvent.Kind<?> getKind() {
        return this.kind;
    }
}
