package com.example.wikimovies.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wikimovies.Controller.DataController;
import com.example.wikimovies.Controller.LoginController;
import com.example.wikimovies.R;

import static com.example.wikimovies.Activity.MainActivity.existeUsuario;

public class login extends AppCompatActivity {
   // private TextView lblGotoRegister;

    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginErrorMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.txtEmail);
        inputPassword = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);
        loginErrorMsg = findViewById(R.id.login_error);

        Button lblGotoRegister  = findViewById(R.id.btnRegistro);
        lblGotoRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent a = new Intent(login.this, registro.class);
                startActivity(a);
            }
        });

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                loginn();
            }
        });
    }

    public void loginn() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (LoginController.getInstance().doLogin(email, password)) {
            DataController.getInstance().cargarUsuarios();
            //USUARIO= ;
            existeUsuario = true;
            finish();
            Intent a = new Intent(login.this, MainActivity.class);
            startActivity(a);
        } else {
            loginErrorMsg.setText("Contraseña o Email incorrectos!");
        }

    }
}
