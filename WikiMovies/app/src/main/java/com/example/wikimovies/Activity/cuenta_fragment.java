package com.example.wikimovies.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.design.widget.FloatingActionButton;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import static com.example.wikimovies.Activity.MainActivity.DATOS;
import static com.example.wikimovies.Activity.login.USER;
import static com.example.wikimovies.Activity.login.existeUsuario;

import android.content.Intent;

import com.example.wikimovies.Controller.DataController;
import com.example.wikimovies.Datos.Usuario;
import com.example.wikimovies.R;

public class cuenta_fragment extends Fragment {
    EditText nombre;
    EditText apellidos;
    EditText edad;
    EditText email;
    EditText contraseñaActual;
    EditText contraseñaNueva;

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container,

                 Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View root =inflater.inflate(R.layout.activity_cuenta, container, false);
        nombre = root.findViewById(R.id.editarNombre);
        apellidos = root.findViewById(R.id.editarApellidos);
        edad = root.findViewById(R.id.editarEdad);
        email = root.findViewById(R.id.editarEmail);
        contraseñaActual= root.findViewById(R.id.editarPassword1);
        contraseñaNueva= root.findViewById(R.id.editarPassword2);
        if (existeUsuario) {
            nombre.setText(USER.getNombre());
            apellidos.setText(USER.getApellidos());
            edad.setText(Integer.toString(USER.getEdad()));
            email.setText(USER.getEmail());
        }

        FloatingActionButton botnEditar1 = root.findViewById(R.id.editarBootonEditar);
        final FloatingActionButton botnEditar2 = root.findViewById(R.id.editarBootonSave1);
        Button botnEditar3 = root.findViewById(R.id.editarBotoonChangePassword);
        final FloatingActionButton botnEditar4 = root.findViewById(R.id.editarBootonSave2);
        Button botnEditar5= root.findViewById(R.id.editarBotoonUpdateGeneros);


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
                actualizarDatos(root);
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
        actualizarDatos(root);
    }
    });

        botnEditar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), addGeneros_fragment.class);
                startActivity(intent);
            }
        });
return  root;}

    public void actualizarDatos(View root){
        Usuario usuario = new Usuario(nombre.getText().toString(),apellidos.getText().toString(),USER.getPassword(),email.getText().toString(),Integer.parseInt(edad.getText().toString()),USER.getSexo());
        boolean persona= DataController.getInstance().actualizarUsuario(usuario);
        if(persona){
            root.findViewById(R.id.editarMessage1).setVisibility(View.VISIBLE);
            ((TextView)root.findViewById(R.id.editarMessage1)).setText("Datos Actualizados");
            ((FloatingActionButton)root.findViewById(R.id.editarBootonSave1)).hide();
        }else{
            ((TextView)root.findViewById(R.id.editarMessage1)).setText("Ups ! Algo salió mal");
        }
    }

    public void cambiarContraseña(View root){
        Usuario persona= DATOS.cambiarCont(email.getText().toString(),contraseñaActual.getText().toString(),contraseñaNueva.getText().toString());
        if(persona!=null){
            USER=persona;
            root.findViewById(R.id.editarMessage2).setVisibility(View.VISIBLE);
            ((TextView)root.findViewById(R.id.editarMessage2)).setText("Contraseña Actualizada");
            ((FloatingActionButton)root.findViewById(R.id.editarBootonSave2)).hide();
            contraseñaActual.setEnabled(false);
            contraseñaNueva.setEnabled(false);

        }else{
            ((TextView)root.findViewById(R.id.editarMessage2)).setText("Ups ! Algo salió mal");
        }
    }
}
