package com.video.Video.model;

public class VideoWithoutContent {
    public void setId(int id) {
        this.id = id;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    public int getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getFile_extension() {
        return file_extension;
    }

    private int id;
    private String file_name;
    private String file_extension;
}
