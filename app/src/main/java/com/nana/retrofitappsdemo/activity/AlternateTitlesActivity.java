package com.nana.retrofitappsdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.nana.retrofitappsdemo.R;
import com.nana.retrofitappsdemo.methodinterface.MovieInterface;
import com.nana.retrofitappsdemo.model.Titles;
import com.nana.retrofitappsdemo.responses.AlternativeResponse;
import com.nana.retrofitappsdemo.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlternateTitlesActivity extends AppCompatActivity {

    private static final String TAG = AlternateTitlesActivity.class.getSimpleName();
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

        Call<AlternativeResponse> call = apiService.getAlternativeTitles(500, API_KEY);
        call.enqueue(new Callback<AlternativeResponse>() {
            @Override
            public void onResponse(Call<AlternativeResponse> call, Response<AlternativeResponse> response) {
                int statusCode = response.code();
                Log.i(TAG, String.valueOf(statusCode));
                List<Titles> titles = response.body().getTitles();
//                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));

                if (titles != null && titles.size() > 0) {
                    for (Titles t : titles) {
                        Log.i(TAG, t.getIso_3166_1());
                        Log.i(TAG, t.getTitle());
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "NULL ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AlternativeResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
