package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Film {
    private String title;
    private String cast;
    private String description;
    private Integer rating;
    private Integer genresId;

    public Film() {
    }

    @JsonCreator
    public Film(
            @JsonProperty(value = "title") String title,
            @JsonProperty(value = "cast") String cast,
            @JsonProperty(value = "description") String description,
            @JsonProperty(value = "rating") Integer rating,
            @JsonProperty(value = "genresId") Integer genresId) {
        this.title = title;
        this.cast = cast;
        this.description = description;
        this.rating = rating;
        this.genresId = genresId;
    }

    public String getTitle() {
        return title;
    }

    public String getCast() {
        return cast;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getGenresId() {
        return genresId;
    }
}
