package com.musicfy.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface AlbumPresenterInterface {
    interface view{
        void buildRecycler(RecyclerView.Adapter adapter);
        Context getContext();
    }
    interface presenter{
        void getAlbum(int idArtist, int idAlbum);
        void getAllAlbumsFromArtist(int idArtist);
    }
}
