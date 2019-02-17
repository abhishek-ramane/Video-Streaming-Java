package com.video.Video.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class Video {
    @Id
    @GenericGenerator(strategy = "native", name = "gn")
    @GeneratedValue(generator = "gn")
    @Column
    int id;
    @Column
    String file_name;
    @Column
    byte[] file_content;
    @Column
    String file_extension;

    public String getFile_extension() {
        return file_extension;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public byte[] getFile_content() {
        return file_content;
    }

    public void setFile_content(byte[] file_content) {
        this.file_content = file_content;
    }
}
