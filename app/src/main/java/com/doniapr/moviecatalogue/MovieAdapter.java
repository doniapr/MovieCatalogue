package com.doniapr.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return convertView;
    }

    private class ViewHolder{
        private ImageView imgPoster;
        private TextView txtName, txtReleaseDate;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtReleaseDate = view.findViewById(R.id.txt_release_date);
            imgPoster = view.findViewById(R.id.img_poster);
        }

        void bind(Movie movie){
            txtName.setText(movie.getName());
            txtReleaseDate.setText(movie.getDate());
            imgPoster.setImageResource(movie.getPoster());
        }

    }
}
