package com.musicfy.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.musicfy.model.Lyric;

public interface LyricPresenterInterface {
    interface view{
        void buildRecycler(RecyclerView.Adapter adapter);
        Context getContext();
    }
    interface presenter{
        void getLyricsFromTrack(int idArtist, int idAlbum, int idTrack);
    }
}