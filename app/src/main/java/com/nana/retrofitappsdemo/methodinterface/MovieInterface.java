package com.nana.retrofitappsdemo.methodinterface;

import com.nana.retrofitappsdemo.responses.MovieDetailsResponse;
import com.nana.retrofitappsdemo.responses.AlternativeResponse;
import com.nana.retrofitappsdemo.responses.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MovieInterface {

    @GET("movie/{movie_id}/account_states")
    Call<MoviesResponse> getAccountStates(@Path("movie_id") int movie_id, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/alternative_titles")
    Call<AlternativeResponse> getAlternativeTitles(@Path("movie_id") int movie_id, @Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call <MovieDetailsResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
