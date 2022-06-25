package com.phuong.model;

import javax.validation.constraints.*;

public class MusicDto {
    private Integer id;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 500)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Name invalid")
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Singer invalid")
    private String singer;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$", message = "Genre invalid")
    private String genre;

    public MusicDto() {
    }

    public MusicDto(Integer id, String name, String singer, String genre) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
