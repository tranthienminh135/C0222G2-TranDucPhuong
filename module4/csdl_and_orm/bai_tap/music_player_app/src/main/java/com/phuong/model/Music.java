package com.phuong.model;

import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "song_name")
    private String songName;
    private String singer;
    private String category;
    @Column(name = "song_path")
    private String songPath;

    public Music() {
    }

    public Music(Integer id, String songName, String singer, String category, String songPath) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.category = category;
        this.songPath = songPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}
