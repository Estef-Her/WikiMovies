package com.example.wikimovies.Services;

import com.example.wikimovies.Datos.Pelicula;
import com.example.wikimovies.Utils.httpRequester;

import org.apache.http.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesServices {
    private String apikey = "bc742fda54c5bce645dcb30e8c22f91f";
    private String link = "https://api.themoviedb.org/3";
    ArrayList<Object> pelis = new ArrayList<>();
    private static final MoviesServices uniqueInstance = new MoviesServices();
    public static MoviesServices instance(){
        return  uniqueInstance;
    }
    public List<Object> cargarPelisNuevas() {

       /* try {



            try {


                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject car = jsonArray.getJSONObject(i);
                    String adult = car.getString("adult");
                    String backdrop_path = car.getString("backdrop_path");
                    String belongs_to_collection = car.getString("belongs_to_collection");
                    String budget = car.getString("budget");
                    List<Integer> genre_ids = (List<Integer>) car.getJSONArray("genre_ids");
                    String homepage = car.getString("homepage");
                    String imdb_id = car.getString("imdb_id");
                    String original_language = car.getString("original_language");
                    String original_title = car.getString("original_title");
                    String overview = car.getString("overview");
                    String popularity = car.getString("popularity");
                    String poster_path = car.getString("poster_path");
                    String production_companies = car.getString("student");
                    String production_countries = car.getString("production_countries");
                    String release_date = car.getString("release_date");
                    String revenue = car.getString("revenue");
                    String runtime = car.getString("runtime");
                    String spoken_languages = car.getString("spoken_languages");
                    String status = car.getString("status");
                    String tagline = car.getString("tagline");
                    String title = car.getString("title");
                    String video = car.getString("video");
                    String vote_average = car.getString("vote_average");
                    String vote_count = car.getString("vote_count");
                    Pelicula peli = new Pelicula(adult, backdrop_path, belongs_to_collection, budget, genre_ids, homepage, imdb_id, original_language, original_title,
                            overview, popularity, poster_path, production_companies, production_countries, release_date, revenue, runtime, spoken_languages, status,
                            tagline, title, video, vote_average, vote_count);
                    pelis.add(peli);
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return  pelis;
    }




}
