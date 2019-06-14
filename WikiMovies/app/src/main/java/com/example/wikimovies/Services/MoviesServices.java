package com.example.wikimovies.Services;

import com.example.wikimovies.Datos.Movie;
import com.example.wikimovies.Datos.Result;
import com.example.wikimovies.Datos.Result;
import com.example.wikimovies.Datos.Result;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MoviesServices {
    @GET("movie/now_playing")
    Call<Result> getLatestMovies(@Query("api_key") String api_key);

    @GET("discover/movie")
    Call<Result> getPopularMovies(@Query("api_key") String api_key);

    @GET("discover/movie")
    Call<Result> getRMovies(@Query("api_key") String api_key,@Query("certification") String certfication);

    @GET("discover/movie")
    Call<Result> getBestYearMovies(@Query("api_key") String api_key,@Query("primary_release_year") String year);

    @GET("discover/movie")
    Call<Result> getKidMovies(@Query("api_key") String api_key);

    @GET("discover/movie")
    Call<Result> getByGeneroMovies(@Query("api_key") String apikey,@Query("with_genres") String genero);

    @GET("search/movie")
   Call<Result> searchMovie(@Query("api_key") String api_key,@Query("text")String text);
    //Call<Movie> searchMovie(@QueryMap Map<String,String> queryValue);

    /*
    *  private void searchMovies(String text){
    *     Map<String,String> queryData = new HashMap<>();
    *     queryData.put("text", text);
    *     queryData.put("apikey", "bc742fda54c5bce645dcb30e8c22f91f");
    *  }
    * */
}
