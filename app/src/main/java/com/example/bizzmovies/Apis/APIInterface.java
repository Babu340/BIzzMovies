package com.example.bizzmovies.Apis;

import com.example.bizzmovies.Dto.MovieDTO;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {



  /*  @POST("ApiController/driverlogin")
    Call<LoginDTO> callLoginApi(@Body LoginModel loginModel);*/

  //  https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=fd75d8c708d418f9ee6280f179e7f399
    @GET("3/discover/movie?sort_by=popularity.desc&api_key=fd75d8c708d418f9ee6280f179e7f399")
    Call<MovieDTO> getMovieDetails();



}

