package com.example.wikimovies.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wikimovies.Datos.Genero;
import com.example.wikimovies.R;

import java.util.List;
import java.util.ArrayList;

import static com.example.wikimovies.Activity.MainActivity.DATOS;
import static com.example.wikimovies.Activity.login.USER;
import static com.example.wikimovies.Activity.login.existeUsuario;

public class addGeneros extends AppCompatActivity {
    List<String> seleccionados= new ArrayList<>();
    TextView seleccionadosLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_generos);
        seleccionadosLabel= findViewById(R.id.seleccionadosCheck);
        Button registrarButoon= findViewById(R.id.btnaddGeneros);
        registrarButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listo();}
        });
        if(existeUsuario){
            for(PeliGeneros p : USER.getGenerosPelis()) {

                seleccionados.add(p.getDescripcion());
            }
            preperarCheck();

        }
    }

    public void preperarCheck(){
       for(String s : seleccionados){
           switch (s){
               case "Accion":
                   ((CheckBox)findViewById(R.id.generoAccion)).setChecked(true);
                   break;
               case "Animacion":
                   ((CheckBox)findViewById(R.id.generoAnimacion)).setChecked(true);
                   break;
               case "Aventura":
                   ((CheckBox)findViewById(R.id.generoAventura)).setChecked(true);
                   break;
               case "Belica":
                   ((CheckBox)findViewById(R.id.generoBelica)).setChecked(true);
                   break;
               case "Comedia":
                   ((CheckBox)findViewById(R.id.generoComedia)).setChecked(true);
                   break;
               case "Ciencia Ficcion":
                   ((CheckBox)findViewById(R.id.generoCienciaFiccion)).setChecked(true);
                   break;
               case "Crimen":
                   ((CheckBox)findViewById(R.id.generoCrimen)).setChecked(true);
                   break;
               case "Documental":
                   ((CheckBox)findViewById(R.id.generoDocumental)).setChecked(true);
                   break;
               case "Drama":
                   ((CheckBox)findViewById(R.id.generoDrama)).setChecked(true);
                   break;
               case "Familia":
                   ((CheckBox)findViewById(R.id.generoFamilia)).setChecked(true);
                   break;
               case "Fantasia":
                   ((CheckBox)findViewById(R.id.generoFantasía)).setChecked(true);
                   break;
               case "Historia":
                   ((CheckBox)findViewById(R.id.generoHistoria)).setChecked(true);
                   break;
               case "Misterio":
                   ((CheckBox)findViewById(R.id.generoMisterio)).setChecked(true);
                   break;
               case "Musica":
                   ((CheckBox)findViewById(R.id.generoMusica)).setChecked(true);
                   break;
               case "Pelicula De TV":
                   ((CheckBox)findViewById(R.id.generoPeliculaDeTv)).setChecked(true);
                   break;
               case "Romance":
                   ((CheckBox)findViewById(R.id.generoRomance)).setChecked(true);
                   break;
               case "Suspense":
                   ((CheckBox)findViewById(R.id.generoSuspense)).setChecked(true);
                   break;
               case "Terror":
                   ((CheckBox)findViewById(R.id.generoTerror)).setChecked(true);
                   break;
               case "Western":
                   ((CheckBox)findViewById(R.id.generoWestern)).setChecked(true);
                   break;
               default:
                    break;
           }
       }
    }
    public void listo(){
        for (String s: seleccionados) {
            DATOS.addGenerosQuemados(USER.getEmail(),s);
            Toast.makeText(this,"Añadido",Toast.LENGTH_LONG).show();
        }
        finish();
        Intent a = new Intent(addGeneros.this, MainActivity.class);
        startActivity(a);
    }
    public void RemoverDato(String s){
        seleccionados.remove(s);
    }

    public void onCheckboxClicked(View view){
        boolean checked=((CheckBox)view).isChecked();
        switch(view.getId()){
            case R.id.generoAccion:
                if(checked){
                    seleccionados.add("Accion");

                }else{
                    RemoverDato("Accion");
                }
                break;
            case R.id.generoAnimacion:
                if(checked){
                    seleccionados.add("Animacion");

                }else{
                    RemoverDato("Animacion");
                }
                break;
            case R.id.generoAventura:
                if(checked){
                    seleccionados.add("Aventura");

                }else{
                    RemoverDato("Aventura");
                }
                break;
            case R.id.generoBelica:
                if(checked){
                    seleccionados.add("Belica");

                }else{
                    RemoverDato("Belica");
                }
                break;
            case R.id.generoCienciaFiccion:
                if(checked){
                    seleccionados.add("Ciencia Ficcion");
                }else{
                    RemoverDato("Ciencia Ficcion");
                }
                break;
            case R.id.generoComedia:
                if(checked){
                    seleccionados.add("Comedia");

                }else{
                    RemoverDato("Comedia");
                }
                break;
            case R.id.generoCrimen:
                if(checked){
                    seleccionados.add("Crimen");

                }else{
                    RemoverDato("Crimen");
                }
                break;
            case R.id.generoDocumental:
                if(checked){
                    seleccionados.add("Documental");

                }else{
                    RemoverDato("Documental");
                }
                break;
            case R.id.generoDrama:
                if(checked){
                    seleccionados.add("Drama");

                }else{
                    RemoverDato("Drama");
                }
                break;
            case R.id.generoFamilia:
                if(checked){
                    seleccionados.add("Familia");

                }else{
                    RemoverDato("Familia");
                }
                break;
            case R.id.generoFantasía:
                if(checked){
                    seleccionados.add("Fantasia");
                }else{
                    RemoverDato("Fantasia");
                }
                break;
            case R.id.generoHistoria:
                if(checked){
                    seleccionados.add("Historia");

                }else{
                    RemoverDato("Historia");
                }
                break;
            case R.id.generoMisterio:
                if(checked){
                    seleccionados.add("Misterio");
                }else{
                    RemoverDato("Misterio");
                }
                break;
            case R.id.generoMusica:
                if(checked){
                    seleccionados.add("Musica");

                }else{
                    RemoverDato("Musica");
                }
                break;
            case R.id.generoPeliculaDeTv:
                if(checked){
                    seleccionados.add("Pelicula De TV");

                }else{
                    RemoverDato("Pelicula De TV");
                }
                break;
            case R.id.generoRomance:
                if(checked){
                    seleccionados.add("Romance");

                }else{
                    RemoverDato("Romance");
                }
                break;
            case R.id.generoSuspense:
                if(checked){
                    seleccionados.add("Suspense");
                }else{
                    RemoverDato("Suspense");
                }
                break;
            case R.id.generoTerror:
                if(checked){
                    seleccionados.add("Terror");

                }else{
                    RemoverDato("Terror");
                }
                break;
            case R.id.generoWestern:
                if(checked){
                    seleccionados.add("Western");

                }else{
                    RemoverDato("Western");
                }
                break;


        }
        if(seleccionados.toString().equals("[]")){
            seleccionadosLabel.setText("");
        }else{
        seleccionadosLabel.setText(seleccionados.toString());}
    }
}
