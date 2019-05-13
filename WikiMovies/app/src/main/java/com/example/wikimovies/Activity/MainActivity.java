package com.example.wikimovies.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MenuInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import com.example.wikimovies.Datos.Modelo;
import com.example.wikimovies.Datos.Persona;
import com.example.wikimovies.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final Modelo DATOS= new Modelo();
    public static  Persona USUARIO;
    public static boolean existeUsuario=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

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
    void login(){
        finish();
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
          USUARIO=new Persona();
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
