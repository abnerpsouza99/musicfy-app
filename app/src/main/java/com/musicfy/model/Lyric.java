package com.musicfy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lyric {

    private String artist;
    private int id;
    private int idTrack;
    private int idAlbum;
    private String albumName;
    private String lyrics;
    private String apiArtist;
    private String apiAlbums;
    private String apiTracks;
    private String apiTrack;
    private String apyLyrics;
    private String lang;
    private String copyrightLabel;
    private String copyrightNotice;
    private String copyrightText;

}
