package com.e.portalfilm.retrofit;

import com.e.portalfilm.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("movie/popular")
    Call<ResponseMovie>  ambilDataMovie(
            @Query("api_key") String apikey

    );


}
