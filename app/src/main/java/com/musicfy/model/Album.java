package com.musicfy.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Parcelable {

    private String albumName;
    private int id;
    private int idArtist;
    private String artistName;
    private String cover;
    private String upc;
    private String asin;
    private String mbid;
    private String realease;
    private String label;
    private boolean explicit;
    private String apiArtist;
    private String apiAlbums;
    private String apiAlbum;
    private String apiTracks;

    protected Album(Parcel in) {
        albumName = in.readString();
        id = in.readInt();
        idArtist = in.readInt();
        artistName = in.readString();
        cover = in.readString();
        upc = in.readString();
        asin = in.readString();
        mbid = in.readString();
        realease = in.readString();
        label = in.readString();
        explicit = in.readByte() != 0;
        apiArtist = in.readString();
        apiAlbums = in.readString();
        apiAlbum = in.readString();
        apiTracks = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", id=" + id +
                ", idArtist=" + idArtist +
                ", artistName='" + artistName + '\'' +
                ", cover='" + cover + '\'' +
                ", upc='" + upc + '\'' +
                ", asin='" + asin + '\'' +
                ", mbid='" + mbid + '\'' +
                ", release='" + realease + '\'' +
                ", label='" + label + '\'' +
                ", explicit='" + explicit + '\'' +
                ", apiArtist='" + apiArtist + '\'' +
                ", apiAlbums='" + apiAlbums + '\'' +
                ", api_album='" + apiAlbum + '\'' +
                ", apiTracks='" + apiTracks + '\'' +
                '}';
    }

    public Album(JSONObject result){
        super();
        try{
            this.id = result.getInt("id_album");
            this.idArtist = result.getInt("id_artist");
            this.albumName = result.has("album") ? result.getString("album") : "";
            this.artistName = result.has("artist") ? result.getString("artist") : "";
            this.cover = result.has("cover") ? result.getString("cover") : "";
            this.upc = result.has("") ? result.getString("upc") : "";
            this.asin = result.has("asin") ? result.getString("asin") : "";
            this.mbid = result.has("mbid") ? result.getString("mdib") : "";
            this.realease = result.has("realease") ? result.getString("realease") : "";
            this.label = result.has("label") ? result.getString("label") : "";
            this.explicit = result.getBoolean("explicit");
            this.apiArtist = result.has("api_artist") ? result.getString("api_artist") : "";
            this.apiAlbums = result.has("api_albums") ? result.getString("api_albums") : "";
            this.apiAlbum = result.has("api_album") ? result.getString("api_album") : "";
            this.apiTracks = result.has("api_tracks") ? result.getString("api_tracks") : "";
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
        dest.writeString(this.albumName);
        dest.writeInt(this.id);
        dest.writeInt(this.idArtist);
        dest.writeString(this.artistName);
        dest.writeString(this.cover);
        dest.writeString(this.upc);
        dest.writeString(this.asin);
        dest.writeString(this.mbid);
        dest.writeString(this.realease);
        dest.writeString(this.label);
        dest.writeBoolean(this.explicit);
        dest.writeString(this.apiArtist);
        dest.writeString(this.apiAlbums);
        dest.writeString(this.apiAlbum);
        dest.writeString(this.apiTracks);
    }
}
