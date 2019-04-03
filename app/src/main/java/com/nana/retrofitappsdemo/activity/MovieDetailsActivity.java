package com.nana.retrofitappsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.nana.retrofitappsdemo.R;
import com.nana.retrofitappsdemo.methodinterface.MovieInterface;
import com.nana.retrofitappsdemo.model.Genres;
import com.nana.retrofitappsdemo.responses.MovieDetailsResponse;
import com.nana.retrofitappsdemo.rest.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {

    private static final String TAG = MovieDetailsActivity.class.getSimpleName();
    private final static String API_KEY = "8f68730a9235161cead84912eb82195d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view_details);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MovieInterface apiService = ApiClient.getClient().create(MovieInterface.class);

        Call<MovieDetailsResponse> call = apiService.getMovieDetails(500, API_KEY);
        call.enqueue(new Callback<MovieDetailsResponse>() {
            @Override
            public void onResponse(Call<MovieDetailsResponse> call, Response<MovieDetailsResponse> response) {
                int statusCode = response.code();
                Log.i(TAG, String.valueOf(statusCode));
//                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));

                if (response != null) {
                    if (response.body().getGenres() != null && response.body().getGenres().size() > 0) {
                        for (Genres g : response.body().getGenres()) {
                            Log.i(TAG, String.valueOf(g.getId()));
                            Log.i(TAG, g.getName());
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "NULL ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieDetailsResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
