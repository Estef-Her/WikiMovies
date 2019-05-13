package com.example.wikimovies.Activity;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.support.design.widget.FloatingActionButton;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import android.content.Context;

import static com.example.wikimovies.Activity.MainActivity.DATOS;
import static com.example.wikimovies.Activity.MainActivity.USUARIO;
import static com.example.wikimovies.Activity.MainActivity.existeUsuario;

import android.content.Intent;

import com.example.wikimovies.Datos.Persona;
import com.example.wikimovies.R;

public class cuenta extends AppCompatActivity {
    EditText nombre;
    EditText apellidos;
    EditText edad;
    EditText email;
    EditText contraseñaActual;
    EditText contraseñaNueva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
        nombre = (EditText) findViewById(R.id.editarNombre);
        apellidos = (EditText) findViewById(R.id.editarApellidos);
        edad = (EditText) findViewById(R.id.editarEdad);
        email = (EditText) findViewById(R.id.editarEmail);
        contraseñaActual=(EditText)findViewById(R.id.editarPassword1);
        contraseñaNueva=(EditText)findViewById(R.id.editarPassword2);
        if (existeUsuario) {
            nombre.setText(USUARIO.getNombre());
            apellidos.setText(USUARIO.getApellidos());
            edad.setText(Integer.toString(USUARIO.getEdad()));
            email.setText(USUARIO.getEmail());
        }

        FloatingActionButton botnEditar1 = (FloatingActionButton) findViewById(R.id.editarBootonEditar);
        final FloatingActionButton botnEditar2 = (FloatingActionButton) findViewById(R.id.editarBootonSave1);
        Button botnEditar3 = (Button) findViewById(R.id.editarBotoonChangePassword);
        final FloatingActionButton botnEditar4 = (FloatingActionButton) findViewById(R.id.editarBootonSave2);


        botnEditar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setEnabled(true);
                apellidos.setEnabled(true);
                edad.setEnabled(true);
                botnEditar2.show();
            }
        });

        botnEditar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDatos();
            }
        });


     botnEditar3.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        contraseñaActual.setEnabled(true);
        contraseñaNueva.setEnabled(true);
        botnEditar4.show();
    }
    });

        botnEditar4.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        actualizarDatos();
    }
    });
}

    public void actualizarDatos(){
        Persona persona= DATOS.actualizarDatos(email.getText().toString(),nombre.getText().toString(),apellidos.getText().toString(),Integer.parseInt(edad.getText().toString()));
        if(persona!=null){
            USUARIO=persona;
            ((TextView)findViewById(R.id.editarMessage1)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.editarMessage1)).setText("Datos Actualizados");
            ((FloatingActionButton)findViewById(R.id.editarBootonSave1)).hide();
        }else{
            ((TextView)findViewById(R.id.editarMessage1)).setText("Ups ! Algo salió mal");
        }
    }

    public void cambiarContraseña(){
        Persona persona= DATOS.cambiarCont(email.getText().toString(),contraseñaActual.getText().toString(),contraseñaNueva.getText().toString());
        if(persona!=null){
            USUARIO=persona;
            ((TextView)findViewById(R.id.editarMessage2)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.editarMessage2)).setText("Contraseña Actualizada");
            ((FloatingActionButton)findViewById(R.id.editarBootonSave2)).hide();
            contraseñaActual.setEnabled(false);
            contraseñaNueva.setEnabled(false);

        }else{
            ((TextView)findViewById(R.id.editarMessage2)).setText("Ups ! Algo salió mal");
        }
    }
}
