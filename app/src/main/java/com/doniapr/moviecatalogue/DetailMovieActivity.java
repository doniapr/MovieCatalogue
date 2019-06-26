package com.doniapr.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
     TextView txtDetailName, txtDetailGenre, txtDetailRuntime, txtDetailDirector, txtDetailSinopsis;
     ImageView imgDetailPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        txtDetailName = findViewById(R.id.txt_detail_name);
        txtDetailGenre = findViewById(R.id.txt_detail_genre);
        txtDetailRuntime = findViewById(R.id.txt_detail_runtime);
        txtDetailDirector = findViewById(R.id.txt_detail_director);
        txtDetailSinopsis = findViewById(R.id.txt_detail_sinopsis);
        imgDetailPoster = findViewById(R.id.img_detail_poster);

        Movie movie = getIntent().getParcelableExtra(MainActivity.EXTRA_MOVIE);

        super.setTitle(movie.getName());

        txtDetailName.setText(movie.getName());
        txtDetailGenre.setText(movie.getGenre());
        txtDetailRuntime.setText(movie.getRuntime());
        txtDetailDirector.setText(movie.getDirector());
        txtDetailSinopsis.setText(movie.getSinopsis());
        imgDetailPoster.setImageResource(movie.getPoster());

    }
}
