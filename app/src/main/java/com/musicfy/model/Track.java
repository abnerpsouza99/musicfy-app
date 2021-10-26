package com.musicfy.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

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

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackName='" + trackName + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", bpm=" + bpm +
                ", lang='" + lang + '\'' +
                ", hasLyrics=" + hasLyrics +
                ", apiTrack='" + apiTrack + '\'' +
                ", apiLyrics='" + apiLyrics + '\'' +
                '}';
    }

    public Track(JSONObject result){
        super();
        try{
            this.id = result.getInt("id_track");
            this.trackName = result.has("track") ? result.getString("track") : "";
            this.artist = result.has("artist") ? result.getString("artist") : "";
            this.album = result.has("album") ? result.getString("album") : "";
            this.bpm = result.has("bpm") && (result.get("bpm") instanceof Integer) ? result.getInt("bpm"): 0;
            this.lang = result.has("lang") ? result.getString("lang") : "";
            this.hasLyrics = result.has("haslyrics") ? result.getBoolean("haslyrics") : result.getBoolean("haslyrics");
            this.apiTrack = result.has("api_track") ? result.getString("api_track") : "";
            this.apiLyrics = result.has("api_lyrics") ? result.getString("api_lyrics") : "";
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

}
