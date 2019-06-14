package com.example.wikimovies.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wikimovies.Datos.Movie;
import com.example.wikimovies.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapterMovie extends RecyclerView.Adapter<ListViewAdapterMovie.MovieHolder> {
    Context mContext;
    LayoutInflater inflater;
    private List<Movie> movies=null;
    private ArrayList<Movie> arrayList;

    public class MovieHolder extends RecyclerView.ViewHolder {
        ImageView poster;

        public MovieHolder(View view){
            super(view);
            poster = view.findViewById(R.id.moviePoster);
        }
    }
    public ListViewAdapterMovie(List<Movie> movies, Context context){
        mContext=context;
        this.movies=movies;
        inflater=LayoutInflater.from(mContext);
        this.arrayList= new ArrayList<Movie>();
        if(movies !=null){
            this.arrayList.addAll(movies);
        }else{this.arrayList.addAll(new ArrayList<Movie>());}

    }
    public void setCursos(List<Movie> cursos){
        this.movies=cursos;
        this.arrayList= new ArrayList<Movie>();
        this.arrayList.addAll(cursos);
        notifyDataSetChanged();
    }
    @Override
    public ListViewAdapterMovie.MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_element, parent, false);

        return new ListViewAdapterMovie.MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movie c  =movies.get(position);

        String ur="https://api.themoviedb.org/3/"+c.getPosterPath();
        try {
            URL url= new URL(ur);
            Bitmap bmp= BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.poster.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*if(modo=="matricular"){
            holder.nombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm1;
                    FragmentTransaction ft1;
                    fm1= (((FragmentActivity)mContext).getSupportFragmentManager());
                    ft1=fm1.beginTransaction();
                    ft1.replace(R.id.fragment_container, new busquedaMatricula());
                    ft1.addToBackStack(null).commit();
                }
            });
        }*/
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount(){
        return movies.size();
    }
    public Movie getCursorAt(int position){
        return  movies.get(position);
    }
    public void delete(Movie al){
        movies.remove(al);
        notifyDataSetChanged();
    }
    public void add(Movie al){
        movies.add(al);
        notifyDataSetChanged();
    }
    // Función filtrar
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        movies.clear();
        if (charText.length() == 0) {
            movies.addAll(arrayList);
        } else {
            for (Movie wp : arrayList) {
                if ((wp.getOriginalTitle().toLowerCase(Locale.getDefault()).contains(charText))) {
                    movies.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
