package com.example.wikimovies.Controller;

import com.example.wikimovies.Datos.Usuario;
import com.example.wikimovies.Model.LoginModel;

import org.json.JSONObject;
import static com.example.wikimovies.Activity.login.USER;
import static com.example.wikimovies.Activity.login.existeUsuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginController {
    String host="10.251.32.96";
    String puerto="8080";
    private LoginModel model = new LoginModel();
    private static final LoginController ourInstance = new LoginController();

    public static LoginController getInstance() {
        return ourInstance;
    }

    private LoginController() {

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }

    public boolean doLogin(String user , String pass){
        boolean res= false;
        DataController.getInstance().cargarAplicacion();
        String apiUrl = "http://"+host+":"+puerto+"/Wiki_Server/doLogin?email="+user+"&key="+pass;

        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }

                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                String email= jsonObject.getString("email");
                String clave=jsonObject.getString("key");
                String rol=jsonObject.getString("rol");
                Usuario usuario =  new Usuario();
                usuario.setRol(rol);
                usuario.setEmail(email);
                usuario.setPassword(clave);
                USER =usuario;
                existeUsuario=true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
