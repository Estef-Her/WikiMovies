package com.example.wikimovies.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.wikimovies.Datos.Usuario;
import com.example.wikimovies.R;

import static com.example.wikimovies.Activity.MainActivity.DATOS;
import static com.example.wikimovies.Activity.login.USER;

public class registro extends AppCompatActivity {
    String nombre ;
    String apellidos;
    String email;
    String password;
    int edad;
    String sexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        RadioButton radioMasculino =findViewById(R.id.masculino);
        radioMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexo="M";
            }
        });
        RadioButton radioFemenino= findViewById(R.id.femenino);
        radioFemenino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexo="F";
            }
        });
        TextView lblGotoRegister = findViewById(R.id.link_to_login);
        lblGotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(registro.this, login.class);
                startActivity(a);}
        });

        Button regB= findViewById(R.id.btnRegister);
        regB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               registrar();}
        });
    }

    public void registrar(){
        nombre=((EditText)findViewById(R.id.userNombre)).getText().toString();
        apellidos=((EditText)findViewById(R.id.userApellidos)).getText().toString();
        email=((EditText)findViewById(R.id.userEmail)).getText().toString();
        password=((EditText)findViewById(R.id.userEdad)).getText().toString();
        String ed = ((EditText)findViewById(R.id.userEdad)).getText().toString();
        if(!ed.equals("")){
            edad=Integer.parseInt(ed);
        }else{edad=0;}
        if(nombre.equals("") || apellidos.equals("") || password.equals("") || email.equals("") || edad==0){
            ((TextView)findViewById(R.id.register_error)).setText("Datos invalidos o campos vacios!");
        }else{
            Usuario user= new Usuario(nombre,apellidos,password,email,edad,sexo);
            DATOS.agregarUsuarioQuemado(user);
            USER=user;
            Toast.makeText(this,"Usuario registrado!",Toast.LENGTH_LONG).show();
            Intent a = new Intent(registro.this, addGeneros.class);
            startActivity(a);
        }
    }
}
