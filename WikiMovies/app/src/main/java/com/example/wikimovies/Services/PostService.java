package com.example.wikimovies.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    String API_ROUTE = "https://api.themoviedb.org/3";
    @GET(API_ROUTE)
    Call< List<Post> > getPost();

}
