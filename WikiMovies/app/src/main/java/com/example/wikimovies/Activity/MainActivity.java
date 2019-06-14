package com.example.wikimovies.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuInflater;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import com.example.wikimovies.Datos.Modelo;
import com.example.wikimovies.Datos.Movie;
import com.example.wikimovies.Datos.Result;
import com.example.wikimovies.Datos.Usuario;
import com.example.wikimovies.Services.MoviesServices;
import com.example.wikimovies.Services.RetrofitInstance;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import static com.example.wikimovies.Activity.login.USER;
import static com.example.wikimovies.Activity.login.existeUsuario;
import com.example.wikimovies.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final Modelo DATOS= new Modelo();
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
    String api_key = "bc742fda54c5bce645dcb30e8c22f91f";
    CarouselView carouselView;

    int[] sampleImages = {R.drawable.poster1, R.drawable.poster2, R.drawable.poster3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getLatestMovies();
        getPopularMovies();
        getBestMovies();
        getKidMovies();
        getRMovies();
        searchMovies();
        getActionMovies();
        getAdventureMovies();
        getAnimationMovies();
        getComedyMovies();
        getCrimeMovies();
        getDocumentaryMovies();
        getDramaMovies();
        getFamillyMovies();
        getFantasyMovies();
        getHistoryMovies();
        getHorrorMovies();
        getMisteryMovies();
        getMusicMovies();
        getRomanceMovies();
        getScienceFictionMovies();
        getThrillerMovies();
        getTVMovies();
        getWarMovies();
        getWesternMovies();
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu){

        if(existeUsuario){
            menu.findItem(R.id.nav_cuenta).setVisible(true);
            menu.findItem(R.id.nav_logout).setVisible(true);
            menu.findItem(R.id.nav_login).setVisible(false);
        }else{
            menu.findItem(R.id.nav_cuenta).setVisible(false);
            menu.findItem(R.id.nav_logout).setVisible(false);
            menu.findItem(R.id.nav_login).setVisible(true);
        }


        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.activity_main_drawer,menu);
        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            Toast.makeText(getApplicationContext(), "Iniciar Sesión", Toast.LENGTH_SHORT).show();
            login();
        } else if (id == R.id.nav_cuenta) {
            Toast.makeText(getApplicationContext(), "Ver Cuenta", Toast.LENGTH_SHORT).show();
            verCuenta();

        } else if (id == R.id.nav_logout) {
            Toast.makeText(getApplicationContext(), "Cerrar Sesion", Toast.LENGTH_SHORT).show();
            logout();
        } else if (id == R.id.nav_acercaDe) {
            Toast.makeText(getApplicationContext(), "Aacerca De", Toast.LENGTH_SHORT).show();
            acercaDe();
        } else if (id == R.id.nav_ayuda) {
            Toast.makeText(getApplicationContext(), "Ayuda", Toast.LENGTH_SHORT).show();
            ayuda();
        } else if (id == R.id.nav_personalizar) {
            Toast.makeText(getApplicationContext(), "Personalizar", Toast.LENGTH_SHORT).show();
            personalizar();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public List<Movie> getLatestMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getLatestMovies(api_key);
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result info = response.body();
                if(info != null){
                    latestMovies = info.getResults();
                    for(Movie p: latestMovies){
                        Log.i("Latest Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("Message", "*******" + "Nothing to do");
            }
        });
        return latestMovies;
    }

    public List<Movie> getPopularMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getPopularMovies(api_key);
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    popularMovies = info.getResults();
                    for(Movie p: popularMovies){
                        Log.i("Popular Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return popularMovies;
    }

    public List<Movie> getKidMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getKidMovies(api_key);
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    kidMovies = info.getResults();
                    for(Movie p: kidMovies){
                        Log.i("Kid Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return kidMovies;
    }

    public List<Movie> getRMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getRMovies(api_key,"R");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    rMovies = info.getResults();
                    for(Movie p: rMovies){
                        Log.i("R Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return rMovies;
    }

    public List<Movie> getDramaMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"18");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    dramaMovies = info.getResults();
                    for(Movie p: dramaMovies){
                        Log.i("Drama Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return dramaMovies;
    }


    public List<Movie> getActionMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"28");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    actionMovies = info.getResults();
                    for(Movie p: actionMovies){
                        Log.i("Action Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return actionMovies;
    }

    public List<Movie> getAdventureMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"12");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    adventureMovies = info.getResults();
                    for(Movie p: adventureMovies){
                        Log.i("Adventure Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return adventureMovies;
    }

    public List<Movie> getAnimationMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"16");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    animateMovies = info.getResults();
                    for(Movie p: animateMovies){
                        Log.i("Animate Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return animateMovies;
    }

    public List<Movie> getComedyMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"35");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    comedyMovies = info.getResults();
                    for(Movie p: comedyMovies){
                        Log.i("Comedy Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return comedyMovies;
    }

    public List<Movie> getCrimeMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"80");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    crimeMovies = info.getResults();
                    for(Movie p: crimeMovies){
                        Log.i("Crime Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return crimeMovies;
    }
    public List<Movie> getBestMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getBestYearMovies(api_key,"2019");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    bestMovies = info.getResults();
                    for(Movie p: bestMovies){
                        Log.i("Best Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return bestMovies;
    }
    public List<Movie> getDocumentaryMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"99");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    documentalMovies = info.getResults();
                    for(Movie p: documentalMovies){
                        Log.i("Documental Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return documentalMovies;
    }
    public List<Movie> getFamillyMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"10751");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    famillyMovies = info.getResults();
                    for(Movie p: famillyMovies){
                        Log.i("Familly Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return famillyMovies;
    }

    public List<Movie> getFantasyMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"14");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    fantasyMovies = info.getResults();
                    for(Movie p: fantasyMovies){
                        Log.i("Fantasy Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return fantasyMovies;
    }
    public List<Movie> getHistoryMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"36");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    historyMovies = info.getResults();
                    for(Movie p: historyMovies){
                        Log.i("History Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return historyMovies;
    }

    public List<Movie> getHorrorMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"27");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    horrorMovies = info.getResults();
                    for(Movie p: horrorMovies){
                        Log.i("Horror Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return horrorMovies;
    }
    public List<Movie> getMusicMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"10402");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    rmusicMovies = info.getResults();
                    for(Movie p: rmusicMovies){
                        Log.i("Musical Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return rmusicMovies;
    }
    public List<Movie> getMisteryMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"9648");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    misteryMovies = info.getResults();
                    for(Movie p: misteryMovies){
                        Log.i("Mistery Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return misteryMovies;
    }
    public List<Movie> getRomanceMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"10749");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    romanceMovies = info.getResults();
                    for(Movie p: romanceMovies){
                        Log.i("Romance Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return romanceMovies;
    }
    public List<Movie> getScienceFictionMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"878");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    sfMovies = info.getResults();
                    for(Movie p: sfMovies){
                        Log.i("SF Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return sfMovies;
    }
    public List<Movie> getThrillerMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"53");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    thrillerMovies = info.getResults();
                    for(Movie p: thrillerMovies){
                        Log.i("Thriller Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return thrillerMovies;
    }

    public List<Movie> getWarMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"10752");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    warMovies = info.getResults();
                    for(Movie p: warMovies){
                        Log.i("War Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return warMovies;
    }
    public List<Movie> getWesternMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"37");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    westernMovies = info.getResults();
                    for(Movie p: westernMovies){
                        Log.i("Western Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return westernMovies;
    }
    public List<Movie> getTVMovies() {
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.getByGeneroMovies(api_key,"10770");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    tvMovies = info.getResults();
                    for(Movie p: tvMovies){
                        Log.i("TV Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return tvMovies;
    }
    public List<Movie> searchMovies() {
        String text = "Avengers";
        MoviesServices services = RetrofitInstance.getService();
        Call<Result> call = services.searchMovie(api_key,text);
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("message", "*******" + response.toString());
                Result info = response.body();
                if(info != null){
                    resultados = info.getResults();
                    for(Movie p: resultados){
                        Log.i("Result Movies", "*******" + p.getTitle());
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("text", "*******" + "Nothing to do");
            }
        });
        return resultados;
    }



    void login(){
        Intent a = new Intent(this, login.class);
        startActivity(a);

    }
    void personalizar(){
        // Intent a = new Intent(this, Personalizar.class);
        // startActivity(a);
    }
    void verCuenta(){
        Intent a = new Intent(this, cuenta.class);
        startActivity(a);
    }
    void logout(){
        finish();
        Intent a = new Intent(this,MainActivity.class);
        USER=new Usuario();
        existeUsuario=false;
        startActivity(a);
    }
    void ayuda(){
        // Intent a = new Intent(this, Ayuda.class);
        // startActivity(a);
    }
    void acercaDe(){
        //  Intent a = new Intent(this, AcercaDe.class);
        //  startActivity(a);
    }



}
