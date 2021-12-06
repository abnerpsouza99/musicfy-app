package com.musicfy.presenter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.musicfy.model.Lyric;
import com.musicfy.model.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class LyricPresenterImpl implements LyricPresenterInterface.presenter, Response.ErrorListener{
    private Lyric lyric;
    private String trackLyrics;
    private LyricPresenterInterface.view activity;
    private Utils utils = new Utils();

    public LyricPresenterImpl(LyricPresenterInterface.view activity){
        this.activity = activity;
    }

    @Override
    public void getLyricsFromTrack(int idArtist, int idAlbum, int idTrack) {
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                utils.getBaseUrl() + "/artists/" + idArtist + "/albums/" + idAlbum + "/tracks/" + idTrack + "/lyrics?apikey=" + utils.getApiKey(),
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetLyricsFromTrack(response);

                    }
                }, this);
        queue.add(request);
    }

    public void onResponseGetLyricsFromTrack(JSONObject response){
        try{
            boolean success = response.getBoolean("success");
            JSONObject result = response.getJSONObject("result");
            if (success){
                lyric = new Lyric(result);
                activity.setLyric(lyric);
            }
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}