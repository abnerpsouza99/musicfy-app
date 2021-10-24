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
public class Artist implements Parcelable {

    private int id;
    private String artistName;
    private String mbid;
    private String gender;
    private String country;
    private String youtubeLink;
    private String instagramLink;
    private String twitterLink;
    private String facebookLink;
    private String website;
    private String spotify;
    private String apiAlbums;

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", mbid='" + mbid + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", instagramLink='" + instagramLink + '\'' +
                ", twitterLink='" + twitterLink + '\'' +
                ", facebookLink='" + facebookLink + '\'' +
                ", website='" + website + '\'' +
                ", spotify='" + spotify + '\'' +
                ", apiAlbums='" + apiAlbums + '\'' +
                '}';
    }

    // Constructor for JSONRequest
    public Artist(JSONObject json){
        super();
        try{
            this.id = json.getInt("id_artist");
            this.artistName     = json.has("artist")     ? json.getString("artist") : "";
            this.mbid           = json.has("mbid")       ? json.getString("mbid") : "";
            this.gender         = json.has("gender")     ? json.getString("gender") : "";
            this.country        = json.has("country")    ? json.getString("country") : "";
            this.youtubeLink    = json.has("youtube")    ? json.getString("youtube") : "";
            this.instagramLink  = json.has("instagram")  ? json.getString("instagram") : "";
            this.twitterLink    = json.has("twitter")    ? json.getString("twitter") : "";
            this.website        = json.has("website")    ? json.getString("website") : "";
            this.spotify        = json.has("spotify")    ? json.getString("spotify") : "";
            this.apiAlbums      = json.has("api_albums") ? json.getString("api_albums") : "";
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    protected Artist(Parcel in) {
        id = in.readInt();
        artistName = in.readString();
        mbid = in.readString();
        country = in.readString();
        gender = in.readString();
        youtubeLink = in.readString();
        instagramLink = in.readString();
        twitterLink = in.readString();
        facebookLink = in.readString();
        website = in.readString();
        spotify = in.readString();
        apiAlbums = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.artistName);
        dest.writeString(this.mbid);
        dest.writeString(this.gender);
        dest.writeString(this.country);
        dest.writeString(this.youtubeLink);
        dest.writeString(this.instagramLink);
        dest.writeString(this.facebookLink);
        dest.writeString(this.twitterLink);
        dest.writeString(this.website);
        dest.writeString(this.spotify);
        dest.writeString(this.apiAlbums);
    }
}
