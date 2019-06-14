package com.example.wikimovies.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.wikimovies.Controller.DataController;
import com.example.wikimovies.Datos.Movie;
import com.example.wikimovies.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class busquedaMovies extends Fragment implements SearchView.OnQueryTextListener {

    // Declarar Variables
    ListView list;
    ListViewAdapterMovie adapter;
    SearchView editsearch;
    private List<Movie> movies= new ArrayList<Movie>();
    CarouselView carouselView;

    int[] sampleImages = {R.drawable.poster1, R.drawable.poster2, R.drawable.poster3};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.principal, container, false);

        super.onCreate(savedInstanceState);
        setMoviesAdapter();
        editsearch = root.findViewById(R.id.busqueda);
        editsearch.setOnQueryTextListener(this);
        RecyclerView recyclerView = root.findViewById(R.id.listaDatos);
        carouselView = root.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(new ImageListener() {

            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {

            }
        });

        return root;
    }

    private void setMoviesAdapter() {
        List<Movie> crs = new ArrayList<Movie>();
        switch(DataController.listaMovies){
            case  "Populares":
                crs=MainActivity.popularMovies;
                break;
            case  "Recientes":
                crs=MainActivity.latestMovies;
                break;
            case  "Para Niños":
                crs=MainActivity.kidMovies;
                break;
            case  "Clasificación R":
                crs=MainActivity.rMovies;
                break;
            case  "Drama":
                crs=MainActivity.dramaMovies;
                break;
            case  "Mejores del año":
                crs=MainActivity.bestMovies;
                break;
            case  "Acción":
                crs=MainActivity.actionMovies;
                break;
            case  "Aventura":
                crs=MainActivity.adventureMovies;
                break;
            case  "Animación":
                crs=MainActivity.animateMovies;
                break;
            case  "Comédia":
                crs=MainActivity.comedyMovies;
                break;
            case  "Crimen":
                crs=MainActivity.crimeMovies;
                break;
            case  "Documental":
                crs=MainActivity.documentalMovies;
                break;
            case  "Familiares":
                crs=MainActivity.famillyMovies;
                break;
            case  "Fantasía":
                crs=MainActivity.fantasyMovies;
                break;
            case  "Historia":
                crs=MainActivity.historyMovies;
                break;
            case  "Horror":
                crs=MainActivity.horrorMovies;
                break;
            case  "Musicales":
                crs=MainActivity.rmusicMovies;
                break;
            case  "Misterio":
                crs=MainActivity.misteryMovies;
                break;
            case  "Suspenso":
                crs=MainActivity.sfMovies;
                break;
            case  "Peliculas de TV":
                crs= MainActivity.tvMovies;
                break;
            case  "Thrilers":
                crs=MainActivity.popularMovies;
                break;
            case  "Bélicas":
                crs=MainActivity.warMovies;
                break;
            case  "Western":
                crs=MainActivity.westernMovies;
                break;
        }
        adapter = new ListViewAdapterMovie(crs, getContext());
    }



    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
