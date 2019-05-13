package com.example.wikimovies.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wikimovies.R;

import java.util.List;
import java.util.ArrayList;

import static com.example.wikimovies.Activity.MainActivity.DATOS;
import static com.example.wikimovies.Activity.MainActivity.USUARIO;

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
    }

    public void listo(){
        for (String s: seleccionados) {
            DATOS.addGenerosQuemados(USUARIO.getEmail(),s);
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
