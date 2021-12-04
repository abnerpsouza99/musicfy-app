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
public class Lyric implements Parcelable {
    private String artist;
    private int idArtist;
    private int idTrack;
    private int idAlbum;
    private String albumName;
    private String lyrics;
    private String apiArtist;
    private String apiAlbums;
    private String apiAlbum;
    private String apiTracks;
    private String apiTrack;
    private String apiLyrics;
    private String lang;
    private String copyrightLabel;
    private String copyrightNotice;
    private String copyrightText;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public int getIdTrack() {
        return idTrack;
    }

    public void setIdTrack(int idTrack) {
        this.idTrack = idTrack;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getApiArtist() {
        return apiArtist;
    }

    public void setApiArtist(String apiArtist) {
        this.apiArtist = apiArtist;
    }

    public String getApiAlbums() {
        return apiAlbums;
    }

    public void setApiAlbums(String apiAlbums) {
        this.apiAlbums = apiAlbums;
    }

    public String getApiAlbum() {
        return apiAlbum;
    }

    public void setApiAlbum(String apiAlbum) {
        this.apiAlbum = apiAlbum;
    }

    public String getApiTracks() {
        return apiTracks;
    }

    public void setApiTracks(String apiTracks) {
        this.apiTracks = apiTracks;
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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCopyrightLabel() {
        return copyrightLabel;
    }

    public void setCopyrightLabel(String copyrightLabel) {
        this.copyrightLabel = copyrightLabel;
    }

    public String getCopyrightNotice() {
        return copyrightNotice;
    }

    public void setCopyrightNotice(String copyrightNotice) {
        this.copyrightNotice = copyrightNotice;
    }

    public String getCopyrightText() {
        return copyrightText;
    }

    public void setCopyrightText(String copyrightText) {
        this.copyrightText = copyrightText;
    }

    public static Creator<Lyric> getCREATOR() {
        return CREATOR;
    }
    protected Lyric(Parcel in) {
        artist = in.readString();
        idArtist = in.readInt();
        idTrack = in.readInt();
        idAlbum = in.readInt();
        albumName = in.readString();
        lyrics = in.readString();
        apiArtist = in.readString();
        apiAlbums = in.readString();
        apiAlbum = in.readString();
        apiTracks = in.readString();
        apiTrack = in.readString();
        apiLyrics = in.readString();
        lang = in.readString();
        copyrightLabel = in.readString();
        copyrightNotice = in.readString();
        copyrightText = in.readString();
    }

    public static final Creator<Lyric> CREATOR = new Creator<Lyric>() {
        @Override
        public Lyric createFromParcel(Parcel in) {
            return new Lyric(in);
        }

        @Override
        public Lyric[] newArray(int size) {
            return new Lyric[size];
        }
    };

    @Override
    public String toString() {
        return "Lyric{" +
                "artist='" + artist + '\'' +
                ", idArtist=" + idArtist +
                ", idTrack=" + idTrack +
                ", idAlbum=" + idAlbum +
                ", albumName='" + albumName + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", apiArtist='" + apiArtist + '\'' +
                ", apiAlbums='" + apiAlbums + '\'' +
                ", apiAlbum='" + apiAlbum + '\'' +
                ", apiTracks='" + apiTracks + '\'' +
                ", apiTrack='" + apiTrack + '\'' +
                ", apyLyrics='" + apiLyrics + '\'' +
                ", lang='" + lang + '\'' +
                ", copyrightLabel='" + copyrightLabel + '\'' +
                ", copyrightNotice='" + copyrightNotice + '\'' +
                ", copyrightText='" + copyrightText + '\'' +
                '}';
    }

    public Lyric(JSONObject result){
        super();
        try{
            this.idArtist = result.getInt("id_artist");
            this.artist = result.has("artist") ? result.getString("artist") : "";
            this.idTrack = result.getInt("id_track");
            this.idAlbum = result.getInt("id_album");
            this.albumName = result.has("album") ? result.getString("album") : "";
            this.lyrics = result.has("lyrics") ? result.getString("lyrics") : "";
            this.apiArtist = result.has("api_artist") ? result.getString("api_artist") : "";
            this.apiAlbums = result.has("api_albums") ? result.getString("api_albums") : "";
            this.apiAlbum = result.has("api_album") ? result.getString("api_album") : "";
            this.apiTracks = result.has("api_tracks") ? result.getString("api_tracks") : "";
            this.apiTrack = result.has("api_track") ? result.getString("api_track") : "";
            this.apiLyrics = result.has("api_lyrics") ? result.getString("api_lyrics") : "";
            this.lang = result.has("lang") ? result.getString("lang") : "";
            this.copyrightLabel = result.has("copyright_label") ? result.getString("copyright_label") : "";
            this.copyrightNotice = result.has("copyright_notice") ? result.getString("copyright_notice") : "";
            this.copyrightText = result.has("copyright_text") ? result.getString("copyright_text") : "";
        } catch (JSONException exception){
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
        dest.writeInt(this.idAlbum);
        dest.writeInt(this.idArtist);
        dest.writeInt(this.idTrack);
        dest.writeString(this.albumName);
        dest.writeString(this.lyrics);
        dest.writeString(this.apiArtist);
        dest.writeString(this.apiAlbums);
        dest.writeString(this.apiAlbum);
        dest.writeString(this.apiTracks);
        dest.writeString(this.apiTrack);
        dest.writeString(this.apiLyrics);
        dest.writeString(this.copyrightLabel);
        dest.writeString(this.copyrightNotice);
        dest.writeString(this.copyrightText);
    }
}
