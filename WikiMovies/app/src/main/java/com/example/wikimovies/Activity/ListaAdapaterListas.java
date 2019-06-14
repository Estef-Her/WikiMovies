/*package com.example.wikimovies.Activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wikimovies.Datos.Movie;
import com.example.wikimovies.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListaAdapaterListas extends RecyclerView.Adapter<ListaAdapterListas.MovieHolder> {
    Context mContext;
    LayoutInflater inflater;
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

    private ArrayList<Movie> ArrpopularMovies;
    private ArrayList<Movie> ArrlatestMovies;
    private ArrayList<Movie> ArrkidMovies;
    private ArrayList<Movie> ArrrMovies;
    private ArrayList<Movie> ArrdramaMovies;
    private ArrayList<Movie> ArrbestMovies;
    private ArrayList<Movie> Arrresultados;
    private ArrayList<Movie> ArractionMovies;
    private ArrayList<Movie> ArradventureMovies;
    private ArrayList<Movie> ArranimateMovies;
    private ArrayList<Movie> ArrcomedyMovies;
    private ArrayList<Movie> ArrcrimeMovies;
    private ArrayList<Movie> ArrdocumentalMovies;
    private ArrayList<Movie> ArrfamillyMovies;
    private ArrayList<Movie> ArrfantasyMovies;
    private ArrayList<Movie> ArrhistoryMovies;
    private ArrayList<Movie> ArrhorrorMovies;
    private ArrayList<Movie> ArrrmusicMovies;
    private ArrayList<Movie> ArrmisteryMovies;
    private ArrayList<Movie> ArrromanceMovies;
    private ArrayList<Movie> ArrsfMovies;
    private ArrayList<Movie> ArrtvMovies;
    private ArrayList<Movie> ArrthrillerMovies;
    private ArrayList<Movie> ArrwarMovies;
    private ArrayList<Movie> ArrwesternMovies;

    public class MovieHolder extends RecyclerView.ViewHolder {
        ImageView poster;

        public MovieHolder(View view){
            super(view);
            poster= ((ImageView)view.findViewById(R.id.moviePoster));
        }
    }
    public ListaAdapaterListas(List<Movie> popularMovies,List<Movie> latestMovies,List<Movie> kidMovies,
                               List<Movie> rMovies, List<Movie> dramaMovies , List<Movie> bestMovies, List<Movie> resultados, List<Movie> actionMovies, List<Movie> adventureMovies, List<Movie> animateMovies , List<Movie> comedyMovies , List<Movie> crimeMovies , List<Movie> documentalMovies, List<Movie> famillyMovies , List<Movie> fantasyMovies , List<Movie> historyMovies , List<Movie> horrorMovies , List<Movie> rmusicMovies, List<Movie> misteryMovies , List<Movie> romanceMovies,
                               List<Movie> sfMovies, List<Movie> tvMovies, List<Movie> thrillerMovies, List<Movie> warMovies, List<Movie> westernMovies
                               ,Context context){
        mContext=context;
        inflater=LayoutInflater.from(mContext);
        this.popularMovies= popularMovies;
        this.ArrpopularMovies= new ArrayList<Movie>();
        this.ArrpopularMovies.addAll(popularMovies);

        this.actionMovies= actionMovies;
        this.ArractionMovies= new ArrayList<Movie>();
        this.ArractionMovies.addAll(actionMovies);

        this.latestMovies= latestMovies;
        this.ArrlatestMovies= new ArrayList<Movie>();
        this.ArrlatestMovies.addAll(latestMovies);

        this.kidMovies= kidMovies;
        this.ArrkidMovies= new ArrayList<Movie>();
        this.ArrkidMovies.addAll(kidMovies);

        this.rMovies= rMovies;
        this.ArrrMovies= new ArrayList<Movie>();
        this.ArrrMovies.addAll(rMovies);

        this.dramaMovies= dramaMovies;
        this.ArrdramaMovies= new ArrayList<Movie>();
        this.ArrdramaMovies.addAll(dramaMovies);

        this.bestMovies= bestMovies;
        this.ArrbestMovies= new ArrayList<Movie>();
        this.ArrbestMovies.addAll(bestMovies);

        this.resultados= resultados;
        this.Arrresultados= new ArrayList<Movie>();
        this.Arrresultados.addAll(resultados);

        this.adventureMovies= adventureMovies;
        this.ArradventureMovies= new ArrayList<Movie>();
        this.ArradventureMovies.addAll(adventureMovies);

        this.animateMovies= animateMovies;
        this.ArranimateMovies= new ArrayList<Movie>();
        this.ArranimateMovies.addAll(animateMovies);

        this.comedyMovies= comedyMovies;
        this.ArrcomedyMovies= new ArrayList<Movie>();
        this.ArrcomedyMovies.addAll(comedyMovies);

        this.crimeMovies= crimeMovies;
        this.ArrcrimeMovies= new ArrayList<Movie>();
        this.ArrcrimeMovies.addAll(crimeMovies);

        this.documentalMovies= documentalMovies;
        this.ArrdocumentalMovies= new ArrayList<Movie>();
        this.ArrdocumentalMovies.addAll(documentalMovies);

        this.famillyMovies=famillyMovies;
        this.ArrfamillyMovies= new ArrayList<Movie>();
        this.ArrfamillyMovies.addAll(famillyMovies);

        this.fantasyMovies= fantasyMovies;
        this.ArrfantasyMovies= new ArrayList<Movie>();
        this.ArrfamillyMovies.addAll(fantasyMovies);

        this.historyMovies= historyMovies;
        this.ArrhistoryMovies= new ArrayList<Movie>();
        this.ArrhistoryMovies.addAll(historyMovies);

        this.horrorMovies=horrorMovies;
        this.ArrhorrorMovies= new ArrayList<Movie>();
        this.ArrhorrorMovies.addAll(horrorMovies);

        this.rmusicMovies= rmusicMovies;
        this.ArrrmusicMovies= new ArrayList<Movie>();
        this.ArrrmusicMovies.addAll(rmusicMovies);

        this.misteryMovies= misteryMovies;
        this.ArrmisteryMovies= new ArrayList<Movie>();
        this.ArrmisteryMovies.addAll(misteryMovies);

        this.romanceMovies= romanceMovies;
        this.ArrromanceMovies= new ArrayList<Movie>();
        this.ArrromanceMovies.addAll(romanceMovies);

        this.sfMovies= sfMovies;
        this.ArrsfMovies= new ArrayList<Movie>();
        this.ArrsfMovies.addAll(sfMovies);

        this.tvMovies= tvMovies;
        this.ArrtvMovies= new ArrayList<Movie>();
        this.ArrtvMovies.addAll(tvMovies);

        this.thrillerMovies= thrillerMovies;
        this.ArrthrillerMovies= new ArrayList<Movie>();
        this.ArrthrillerMovies.addAll(thrillerMovies);

        this.warMovies= warMovies;
        this.ArrwarMovies= new ArrayList<Movie>();
        this.ArrwarMovies.addAll(warMovies);

        this.westernMovies= westernMovies;
        this.ArrwesternMovies= new ArrayList<Movie>();
        this.ArrwesternMovies.addAll(westernMovies);
    }
    @Override
    public ListaAdapaterListas.MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_element, parent, false);

        return new ListaAdapaterListas.MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
      //  Movie c  = cu.get(position);
       // holder.nombre.setText(cursos.get(position).getNombre());
        // holder.codigo.setText(Integer.toString(cursos.get(position).getCodigo()));

    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    // Función filtrar
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        resultados.clear();
        if (charText.length() == 0) {
            resultados.addAll(Arrresultados);
        } else {
            for (Movie wp : arrayList) {
                String ced= Integer.toString(wp.getCodigo());
                if ((wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText))||(ced.toLowerCase(Locale.getDefault()).contains(charText))) {
                    cursos.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}*/