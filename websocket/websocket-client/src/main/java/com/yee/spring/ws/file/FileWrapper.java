package com.yee.spring.ws.file;

import java.io.File;

public class FileWrapper {
    /**
     * 当前文件读取的行数
     */
    private int currentLine;

    /**
     * 监听的文件
     */
    private final File file;

    public FileWrapper(File file) {
        this(file, 0);
    }

    public FileWrapper(File file, int currentLine) {
        this.file = file;
        this.currentLine = currentLine;
    }

    public int getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }

    public File getFile() {
        return file;
    }
}
