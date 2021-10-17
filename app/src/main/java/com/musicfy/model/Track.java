package com.musicfy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Track {

    private int id;
    private String trackName;
    private String artist;
    private String album;
    private int bpm;
    private String lang;
    private boolean hasLyrics;
    private String apiTrack;
    private String apiLyrics;
}
