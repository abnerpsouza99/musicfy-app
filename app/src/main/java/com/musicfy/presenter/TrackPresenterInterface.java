package com.musicfy.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface TrackPresenterInterface {
    interface view {
        public void buildRecycler(RecyclerView.Adapter adapter);
        Context getContext();
    }

    interface presenter {
        void getTrack(int idArtist, int idAlbum, int idTrack);
        void getAllTracksFromAAlbum(int idArtist, int idAlbum);
        void searchTrack();
    }
}
