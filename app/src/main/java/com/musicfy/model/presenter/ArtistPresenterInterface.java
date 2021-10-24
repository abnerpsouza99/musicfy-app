package com.musicfy.model.presenter;

import android.content.Context;

import com.musicfy.model.Artist;

import java.util.List;

public interface ArtistPresenterInterface {
    interface view {
        Context getContext();
    }

    interface presenter {
        void getAllArtistsByPage(int page);
        void getArtistById(int id);
    }
}
