package com.example.wikimovies.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.support.design.widget.FloatingActionButton;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import static com.example.wikimovies.Activity.MainActivity.DATOS;
import static com.example.wikimovies.Activity.login.USER;
import static com.example.wikimovies.Activity.login.existeUsuario;

import android.content.Intent;

import com.example.wikimovies.Datos.Usuario;
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
            nombre.setText(USER.getNombre());
            apellidos.setText(USER.getApellidos());
            edad.setText(Integer.toString(USER.getEdad()));
            email.setText(USER.getEmail());
        }

        FloatingActionButton botnEditar1 = (FloatingActionButton) findViewById(R.id.editarBootonEditar);
        final FloatingActionButton botnEditar2 = (FloatingActionButton) findViewById(R.id.editarBootonSave1);
        Button botnEditar3 = (Button) findViewById(R.id.editarBotoonChangePassword);
        final FloatingActionButton botnEditar4 = (FloatingActionButton) findViewById(R.id.editarBootonSave2);
        Button botnEditar5=(Button)findViewById(R.id.editarBotoonUpdateGeneros);


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

        botnEditar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(cuenta.this, addGeneros.class);
                startActivity(a);
            }
        });
}

    public void actualizarDatos(){
        Usuario persona= DATOS.actualizarDatos(email.getText().toString(),nombre.getText().toString(),apellidos.getText().toString(),Integer.parseInt(edad.getText().toString()));
        if(persona!=null){
            USER=persona;
            ((TextView)findViewById(R.id.editarMessage1)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.editarMessage1)).setText("Datos Actualizados");
            ((FloatingActionButton)findViewById(R.id.editarBootonSave1)).hide();
        }else{
            ((TextView)findViewById(R.id.editarMessage1)).setText("Ups ! Algo salió mal");
        }
    }

    public void cambiarContraseña(){
        Usuario persona= DATOS.cambiarCont(email.getText().toString(),contraseñaActual.getText().toString(),contraseñaNueva.getText().toString());
        if(persona!=null){
            USER=persona;
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
