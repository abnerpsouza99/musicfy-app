package com.musicfy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    private String albumName;
    private int id;
    private int idArtist;
    private String artistName;
    private String cover;
    private String upc;
    private String asin;
    private String mbid;
    private String genres;
    private String release;
    private String label;
    private String explicit;
    private String apiArtist;
    private String apiAlbums;
    private String api_album;
    private String apiTracks;

}
