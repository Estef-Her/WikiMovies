/*package com.example.wikimovies.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.wikimovies.Datos.Movie;
import com.example.wikimovies.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class busquedaListas extends Fragment implements SearchView.OnQueryTextListener{
    ListView list;
    ListaAdapaterListas adapter;
    SearchView editsearch;
    CarouselView carouselView;

    int[] sampleImages = {R.drawable.poster1, R.drawable.poster2, R.drawable.poster3};

    private List<Movie> popularMovies;
    private List<Movie> latestMovies;
    private List<Movie> kidMovies;
    private List<Movie> rMovies;
    private List<Movie> dramaMovies;
    private List<Movie> bestMovies;
    private List<Movie> resultados;
    private List<Movie> actionMovies;
    private List<Movie> adventureMovies;
    private List<Movie> animateMovies;
    private List<Movie> comedyMovies;
    private List<Movie> crimeMovies;
    private List<Movie> documentalMovies;
    private List<Movie> famillyMovies;
    private List<Movie> fantasyMovies;
    private List<Movie> historyMovies;
    private List<Movie> horrorMovies;
    private List<Movie> rmusicMovies;
    private List<Movie> misteryMovies;
    private List<Movie> romanceMovies;
    private List<Movie> sfMovies;
    private List<Movie> tvMovies;
    private List<Movie> thrillerMovies;
    private List<Movie> warMovies;
    private List<Movie> westernMovies;
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.busqueda_generic, container, false);

        super.onCreate(savedInstanceState);
        carouselView = (CarouselView) root.findViewById(R.id.carouselView);
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
        setListasAdapter();
        editsearch = root.findViewById(R.id.busqueda);
        editsearch.setOnQueryTextListener(this);
        RecyclerView reciclerAccion = root.findViewById(R.id.listaAccion);
        RecyclerView reciclerAnimacion = root.findViewById(R.id.listaAnimacion);
        RecyclerView reciclerAventura = root.findViewById(R.id.listaAventura);
        RecyclerView reciclerBelica = root.findViewById(R.id.listaBelica);
        RecyclerView reciclerComedia = root.findViewById(R.id.listaComedia);
        RecyclerView reciclerCienciaF = root.findViewById(R.id.listaCienciaF);
        RecyclerView reciclerCrimen = root.findViewById(R.id.listaCrimen);
        RecyclerView reciclerDocumental = root.findViewById(R.id.listaDocumental);
        RecyclerView reciclerDrama = root.findViewById(R.id.listaDrama);
        RecyclerView reciclerFamilia= root.findViewById(R.id.listaFamilia);
        RecyclerView reciclerFantasia = root.findViewById(R.id.listaFantasia);
        RecyclerView reciclerHistoria = root.findViewById(R.id.listaHistoria);
        RecyclerView reciclerMisterio = root.findViewById(R.id.listaMisterio);
        RecyclerView reciclerMusica = root.findViewById(R.id.listaMusica);
        RecyclerView reciclerPeliculaTv = root.findViewById(R.id.listaPeliculaTv);
        RecyclerView reciclerRomance = root.findViewById(R.id.listaRomance);
        RecyclerView reciclerSuspense = root.findViewById(R.id.listaSuspenso);
        RecyclerView reciclerTerror = root.findViewById(R.id.listaTerror);
        RecyclerView reciclerWestern = root.findViewById(R.id.listaWestern);
        RecyclerView reciclerResultados = root.findViewById(R.id.listaResultados);
        RecyclerView reciclerBest = root.findViewById(R.id.listaBest);
        RecyclerView reciclerPopulares = root.findViewById(R.id.listaPopulares);

        return root;
    }
    private void setListasAdapter() {
        popularMovies= MainActivity.popularMovies;
        latestMovies=MainActivity.latestMovies;
        kidMovies=MainActivity.kidMovies;
        rMovies=MainActivity.kidMovies;
        dramaMovies=MainActivity.kidMovies;
        bestMovies=MainActivity.bestMovies;
        resultados=MainActivity.resultados;
        actionMovies=MainActivity.actionMovies;
        adventureMovies=MainActivity.adventureMovies;
        animateMovies=MainActivity.animateMovies;
        comedyMovies=MainActivity.comedyMovies;
        crimeMovies=MainActivity.crimeMovies;
        documentalMovies=MainActivity.documentalMovies;
        famillyMovies=MainActivity.famillyMovies;
        fantasyMovies=MainActivity.fantasyMovies;
        historyMovies=MainActivity.historyMovies;
        horrorMovies=MainActivity.horrorMovies;
        rmusicMovies=MainActivity.rmusicMovies;
        misteryMovies=MainActivity.misteryMovies;
        romanceMovies=MainActivity.romanceMovies;
        sfMovies=MainActivity.sfMovies;
        tvMovies=MainActivity.tvMovies;
        thrillerMovies=MainActivity.thrillerMovies;
        warMovies=MainActivity.thrillerMovies;
        warMovies=MainActivity.warMovies;
        westernMovies=MainActivity.westernMovies;
        adapter = new ListaAdapaterListas();
    }
}
*/