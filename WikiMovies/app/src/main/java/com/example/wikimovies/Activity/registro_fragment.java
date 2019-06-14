package com.example.wikimovies.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.wikimovies.Controller.DataController;
import com.example.wikimovies.Controller.LoginController;
import com.example.wikimovies.Datos.Usuario;
import com.example.wikimovies.R;

import static com.example.wikimovies.Activity.MainActivity.DATOS;
import static com.example.wikimovies.Activity.login.USER;

public class registro_fragment extends Fragment {

    private UserRegisterTask mAuthTask= null;
    EditText nombre ;
    EditText apellidos;
    EditText email;
    EditText password;
    EditText edad;
    Button regB;
    RadioButton radioMasculino;
    RadioButton radioFemenino;
    String sexo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View root =inflater.inflate(R.layout.fragment_formulario_registro, container, false);
        radioMasculino =root.findViewById(R.id.masculino);
        radioMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexo="M";
            }
        });
        radioFemenino= root.findViewById(R.id.femenino);
        radioFemenino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexo="F";
            }
        });
        nombre=root.findViewById(R.id.userNombre);
        apellidos=root.findViewById(R.id.userApellidos);
        email=root.findViewById(R.id.userEmail);
        password=root.findViewById(R.id.userPassword);
        edad = root.findViewById(R.id.userEdad);
        TextView lblGotoRegister = root.findViewById(R.id.link_to_login);
        lblGotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getContext(), login.class);
                startActivity(a);}
        });

        regB= root.findViewById(R.id.btnRegister);
        regB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               attemptRegistro();}
        });
        return root;
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 7;
    }
    private void attemptRegistro() {
        if (mAuthTask != null) {
            return;
        }
        // Reset errors.
        nombre.setError(null);
        apellidos.setError(null);
        edad.setError(null);
        email.setError(null);
        password.setError(null);

        // Store values at the time of the login attempt.
        String Mnombre=nombre.getText().toString();
        String Mapellidos=apellidos.getText().toString();
        String Memail=email.getText().toString();
        String Mpassword=password.getText().toString();
        String ed = edad.getText().toString();
        int Medad;
        if(!ed.equals("")){
            Medad=Integer.parseInt(ed);
        }else{Medad=0;}

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(Mpassword) ) {
            password.setError("Escriba una contraseĂ±a!");
            focusView = password;
            cancel = true;
        }
        if (TextUtils.isEmpty(Mnombre) ) {
            nombre.setError("Escriba un nombre!");
            focusView = nombre;
            cancel = true;
        }
        if (TextUtils.isEmpty(Mapellidos) ) {
            apellidos.setError("Escriba unos apellidos!");
            focusView = apellidos;
            cancel = true;
        }
        if (TextUtils.isEmpty(ed) ) {
            edad.setError("Escriba una edad!");
            focusView = edad;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(Memail)) {
            email.setError("Escriba un email!");
            focusView =email;
            cancel = true;
        }
        if(!isEmailValid(Memail)){
            email.setError("Escriba un email valido!");
            focusView =email;
            cancel = true;
        }
        if(!isPasswordValid(Mpassword)){
            password.setError("Escriba una contraseña de almenos 8 caracteres!");
            focusView =password;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            mAuthTask = new UserRegisterTask(Mnombre,Mapellidos,Medad,sexo,Memail, Mpassword);
            mAuthTask.execute((Void) null);
        }}



    public class UserRegisterTask extends AsyncTask<Void, Void, Boolean> {
        private final String mNombre;
        private final String mApellidos;
        private final int mEdad;
        private final String mSexo;
        private final String mEmail;
        private final String mPassword;

        UserRegisterTask(String nombre , String apellidos , int edad, String sexo, String email, String password) {
            mNombre=nombre;
            mApellidos=apellidos;
            mEdad=edad;
            mSexo=sexo;
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }
            Usuario user = new Usuario(mNombre,mApellidos,mPassword,mEmail,mEdad,mSexo);
            return DataController.getInstance().addUsuario(user);
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;

            if (success) {
                Toast.makeText(getContext(),"Usuario registrado correctamente!", Toast.LENGTH_SHORT);
                Intent intent = new Intent(getContext(), addGeneros_fragment.class);
                startActivity(intent);

            } else {
                password.setError("Digite una contraseña");
                email.setError("y un email valido");
                password.requestFocus();
                email.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }
}
