package com.musicfy.model;

import com.musicfy.model.Enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    private int id;
    private String artistName;
    private String mbid;
    private Gender gender;
    private String country;
    private String youtubeLink;
    private String instagramLink;
    private String twitterLink;
    private String facebookLink;
    private String website;
    private String spotify;
    private String apiAlbums;
    
}
