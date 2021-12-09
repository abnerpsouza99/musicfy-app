package com.musicfy.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Track implements Parcelable {

    private int id;
    private int idAlbum;
    private int idArtist;
    private String trackName;
    private String artist;
    private String album;
    private int bpm;
    private String lang;
    private boolean hasLyrics;
    private String apiTrack;
    private String apiLyrics;
    private String cover;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isHasLyrics() {
        return hasLyrics;
    }

    public void setHasLyrics(boolean hasLyrics) {
        this.hasLyrics = hasLyrics;
    }

    public String getApiTrack() {
        return apiTrack;
    }

    public void setApiTrack(String apiTrack) {
        this.apiTrack = apiTrack;
    }

    public String getApiLyrics() {
        return apiLyrics;
    }

    public void setApiLyrics(String apiLyrics) {
        this.apiLyrics = apiLyrics;
    }

    protected Track(Parcel in) {
        id = in.readInt();
        idAlbum = in.readInt();
        idArtist = in.readInt();
        trackName = in.readString();
        artist = in.readString();
        album = in.readString();
        bpm = in.readInt();
        lang = in.readString();
        hasLyrics = in.readByte() != 0;
        apiTrack = in.readString();
        apiLyrics = in.readString();
        cover = in.readString();
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
                ", idAlbum='" + idAlbum + '\'' +
                ", idArtist='" + idArtist + '\'' +
                ", trackName='" + trackName + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", bpm=" + bpm +
                ", lang='" + lang + '\'' +
                ", hasLyrics=" + hasLyrics +
                ", apiTrack='" + apiTrack + '\'' +
                ", apiLyrics='" + apiLyrics + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    public Track(JSONObject result){
        super();
        try{
            this.id = result.getInt("id_track");
            this.idAlbum = result.getInt("id_album");
            this.idArtist = result.getInt("id_artist");
            this.trackName = result.has("track") ? result.getString("track") : "";
            this.artist = result.has("artist") ? result.getString("artist") : "";
            this.album = result.has("album") ? result.getString("album") : "";
            this.bpm = result.has("bpm") && (result.get("bpm") instanceof Integer) ? result.getInt("bpm"): 0;
            this.lang = result.has("lang") ? result.getString("lang") : "";
            this.hasLyrics = result.has("haslyrics") ? result.getBoolean("haslyrics") : result.getBoolean("haslyrics");
            this.apiTrack = result.has("api_track") ? result.getString("api_track") : "";
            this.apiLyrics = result.has("api_lyrics") ? result.getString("api_lyrics") : "";
            this.cover = result.has("cover") ? result.getString("cover") : "";

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
        dest.writeInt(this.idAlbum);
        dest.writeInt(this.idArtist);
        dest.writeString(this.trackName);
        dest.writeString(this.artist);
        dest.writeString(this.album);
        dest.writeInt(this.bpm);
        dest.writeString(this.lang);
        dest.writeBoolean(this.hasLyrics);
        dest.writeString(this.apiTrack);
        dest.writeString(this.apiLyrics);
        dest.writeString(this.cover);
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        return obj.getClass() == Track.class && ((Track) obj).id == this.id;
    }
}