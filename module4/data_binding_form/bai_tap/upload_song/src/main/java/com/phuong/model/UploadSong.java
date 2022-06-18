package com.phuong.model;

public class UploadSong {
    private String songName;
    private String singer;
    private String genres;
    private String link;

    public UploadSong() {
    }

    public UploadSong(String songName, String singer, String genres, String link) {
        this.songName = songName;
        this.singer = singer;
        this.genres = genres;
        this.link = link;
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

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "UploadSong{" +
                "songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                ", genres='" + genres + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
