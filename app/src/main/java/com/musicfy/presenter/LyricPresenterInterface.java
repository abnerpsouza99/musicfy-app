package com.musicfy.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.musicfy.model.Lyric;

public interface LyricPresenterInterface {
    interface view{
        Context getContext();
        void setLyric(Lyric lyric);
    }
    interface presenter{
        void getLyricsFromTrack(int idArtist, int idAlbum, int idTrack);
    }
}