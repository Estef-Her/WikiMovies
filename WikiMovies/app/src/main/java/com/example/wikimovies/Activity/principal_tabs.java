package com.example.wikimovies.Activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.wikimovies.Controller.DataController;
import com.example.wikimovies.R;
public class principal_tabs  extends FragmentActivity {
    private static final String TAG="Principal";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_tabs);
        Log.d(TAG,"onCreate: Starting");
        mSectionsPageAdapter= new SectionsPageAdapter(getSupportFragmentManager());
        AppBarLayout barra= findViewById(R.id.barrTaps);
        mViewPager= findViewById(R.id.containerTab);
        setupViewPage(mViewPager);

        TabLayout tabLayout= findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                DataController.listaMovies=((String)((SectionsPageAdapter)mViewPager.getAdapter()).getPageTitle(i));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private void setupViewPage(ViewPager viewPager){
        SectionsPageAdapter adapter= new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new busquedaMovies(), "Populares");
        adapter.addFragment(new busquedaMovies(), "Recientes");
        adapter.addFragment(new busquedaMovies(), "Para Niños");
        adapter.addFragment(new busquedaMovies(), "Clasificación R");
        adapter.addFragment(new busquedaMovies(), "Drama");
        adapter.addFragment(new busquedaMovies(), "Mejores del año");
        adapter.addFragment(new busquedaMovies(), "Acción");
        adapter.addFragment(new busquedaMovies(), "Aventura");
        adapter.addFragment(new busquedaMovies(), "Animación");
        adapter.addFragment(new busquedaMovies(), "Comédia");
        adapter.addFragment(new busquedaMovies(), "Crimen");
        adapter.addFragment(new busquedaMovies(), "Docuemental");
        adapter.addFragment(new busquedaMovies(), "Familiares");
        adapter.addFragment(new busquedaMovies(), "Fantasía");
        adapter.addFragment(new busquedaMovies(), "Historia");
        adapter.addFragment(new busquedaMovies(), "Horror");
        adapter.addFragment(new busquedaMovies(), "Musicales");
        adapter.addFragment(new busquedaMovies(), "Misterio");
        adapter.addFragment(new busquedaMovies(), "Romance");
        adapter.addFragment(new busquedaMovies(), "Suspenso");
        adapter.addFragment(new busquedaMovies(), "Peliculas de TV");
        adapter.addFragment(new busquedaMovies(), "Thrilers");
        adapter.addFragment(new busquedaMovies(), "Bélicas");
        adapter.addFragment(new busquedaMovies(), "Wastern");
        viewPager.setAdapter(adapter);

    }

}