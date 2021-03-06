package com.chernyshov777.java8inaction.oreilly;

import lombok.Data;

import java.util.List;

@Data
public class Album {
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;
}
