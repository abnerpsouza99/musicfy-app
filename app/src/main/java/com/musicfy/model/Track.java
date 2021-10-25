package com.musicfy.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

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
public class Track implements Parcelable {

    private int id;
    private String trackName;
    private String artist;
    private String album;
    private int bpm;
    private String lang;
    private boolean hasLyrics;
    private String apiTrack;
    private String apiLyrics;

    protected Track(Parcel in) {
        id = in.readInt();
        trackName = in.readString();
        artist = in.readString();
        album = in.readString();
        bpm = in.readInt();
        lang = in.readString();
        hasLyrics = in.readByte() != 0;
        apiTrack = in.readString();
        apiLyrics = in.readString();
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.trackName);
        dest.writeString(this.artist);
        dest.writeString(this.album);
        dest.writeInt(this.bpm);
        dest.writeString(this.lang);
        dest.writeBoolean(this.hasLyrics);
        dest.writeString(this.apiTrack);
        dest.writeString(this.apiLyrics);
    }
}
