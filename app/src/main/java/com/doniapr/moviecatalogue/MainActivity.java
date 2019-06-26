package com.doniapr.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] movieName;
    private String[] releaseDate, sinopsis, director, runtime, genre;
    private TypedArray poster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setTitle("Movie List");

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = new Movie();
                movie.setName(movies.get(position).getName());
                movie.setDate(movies.get(position).getDate());
                movie.setSinopsis(movies.get(position).getSinopsis());
                movie.setDirector(movies.get(position).getDirector());
                movie.setRuntime(movies.get(position).getRuntime());
                movie.setGenre(movies.get(position).getGenre());
                movie.setPoster(movies.get(position).getPoster());

                Intent i = new Intent(MainActivity.this, DetailMovieActivity.class);
                i.putExtra(EXTRA_MOVIE, movie);
                startActivity(i);
            }
        });
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < movieName.length; i++){
            Movie movie = new Movie();
            movie.setPoster(poster.getResourceId(i, -1));
            movie.setName(movieName[i]);
            movie.setDate(releaseDate[i]);
            movie.setGenre(genre[i]);
            movie.setRuntime(runtime[i]);
            movie.setDirector(director[i]);
            movie.setSinopsis(sinopsis[i]);

            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare(){
        movieName = getResources().getStringArray(R.array.movie_name);
        releaseDate = getResources().getStringArray(R.array.release_date);
        poster = getResources().obtainTypedArray(R.array.poster);
        sinopsis = getResources().getStringArray(R.array.sinopsis);
        director = getResources().getStringArray(R.array.director);
        runtime = getResources().getStringArray(R.array.runtime);
        genre = getResources().getStringArray(R.array.genre);

    }
}
