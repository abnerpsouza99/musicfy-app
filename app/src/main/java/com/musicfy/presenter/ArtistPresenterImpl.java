package com.musicfy.presenter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.musicfy.model.Artist;
import com.musicfy.model.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArtistPresenterImpl implements ArtistPresenterInterface.presenter, Response.ErrorListener{

    private List<Artist> artists = new ArrayList<Artist>();
    private Artist singleArtist;
    private ArtistPresenterInterface.view activity;
    private Utils utils = new Utils();

    public ArtistPresenterImpl(ArtistPresenterInterface.view activity){
        this.activity = activity;
    }

    @Override
    public void getAllArtistsByPage(int page){
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                utils.getBaseUrl() + "/artists?page=" + page + "&apikey=" + utils.getApiKey(),
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetAllArtistsByPage(response);
                    }
                }, this);

        queue.add(request);
    }

    @Override
    public void getArtistById(int id) {
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                utils.getBaseUrl() + "/artists/?id_artist=" + id + "&apikey=" + utils.getApiKey(),
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetArtistById(response);
                    }
                }, this);

        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public void onResponseGetAllArtistsByPage(JSONObject response){
        try{
            JSONArray result = response.getJSONArray("result");
            artists.clear();
            // Limitando em 10 registros vindos da API
            for(int i = 0; i < 2; i++){
                Artist artist = new Artist(result.getJSONObject(i));
                artists.add(artist);
            }
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    public void onResponseGetArtistById(JSONObject response){
        try{
            JSONObject result = response.getJSONObject("result");
            Artist artist = new Artist(result);
            System.out.println("Artist: " + artist.toString());

        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    public void searchArtists(){
        // Valores fixos por enquanto para teste
        String query = "";
        int limit = 10;
        boolean lyrics = true;
        String type = "artist";

        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                utils.getBaseUrl() + "?q=" + query + "&limit=" + limit + "&apikey=" + utils.getApiKey() + "&type=" + type + "&lyrics=" + lyrics,
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseSearch(response);
                    }
                }, this);
        queue.add(request);
    }

    public void onResponseSearch(JSONObject response){
        artists.clear();
        try{
            JSONArray result = response.getJSONArray("result");
            for (int i = 0; i < result.length(); i++){
                Artist artist = new Artist(result.getJSONObject(i));
                artists.add(artist);
            }
        }catch (JSONException exception){
            exception.printStackTrace();
        }

    }
}
