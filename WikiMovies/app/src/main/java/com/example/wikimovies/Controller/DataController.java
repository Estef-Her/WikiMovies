package com.example.wikimovies.Controller;


import android.os.StrictMode;

import com.example.wikimovies.Datos.Favorito;
import com.example.wikimovies.Datos.Genero;
import com.example.wikimovies.Datos.Usuario;
import com.example.wikimovies.Model.DatosModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import static com.example.wikimovies.Activity.login.USER;
import static com.example.wikimovies.Activity.login.existeUsuario;

public class DataController {
    private DatosModel model = new DatosModel();
    public static String listaMovies;
    private static final DataController ourInstance = new DataController();

    public DataController() {
        model= new DatosModel();
    }

    public DatosModel getModel() {
        return model;
    }

    public void setModel(DatosModel model) {
        this.model = model;
    }

    public static DataController getInstance() {
        return ourInstance;
    }

    public Favorito buscarFavoritosXId(String user){
        Favorito resul=null;
        for(Favorito f : model.getFavoritos()){
            if(f.getUsuario()==user){
                resul=f;
            }
        }
        return resul;
    }
    public Genero buscarGeneroXId(String user){
        Genero resul=null;
        for(Genero p : model.getGeneros()){
            if(p.getUsuario()==user){
                resul=p;
            }
        }
        return resul;
    }

    public void serializarUsuario(JSONObject jsonObject) throws JSONException {
        Usuario u = new Usuario();
        u.setApellidos(jsonObject.getString("apellidos"));
        u.setNombre(jsonObject.getString("nombre"));
        u.setEdad(Integer.getInteger(jsonObject.getString("edad")));
        u.setEmail(jsonObject.getString("email"));
        u.setPassword(jsonObject.getString("key"));
        u.setSexo(jsonObject.getString("sexo"));
        u.setGenerosPelis((List<Genero>) this.buscarGeneroXId(u.getEmail()));
        u.setPelisFavoritas((List<Favorito>) this.buscarFavoritosXId(u.getEmail()));
    }


    public void serializarUsuarios(JSONObject jsonObject) throws JSONException {
        List<Usuario> usuarios = new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            String nombre = car.getString("nombre");
            String apellidos = car.getString("apellidos");
            String password = car.getString("password");
            String email = car.getString("email");
            int edad = car.getInt("edad");
            String sexo = car.getString("sexo");
            String rol = car.getString("rol");

            Usuario u = new Usuario();
            u.setPassword(password);
            u.setEmail(email);
            u.setSexo(sexo);
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setGenerosPelis((List<Genero>) this.buscarGeneroXId(u.getEmail()));
            u.setPelisFavoritas((List<Favorito>) this.buscarFavoritosXId(u.getEmail()));
            usuarios.add(u);
        }
        model.setUsuarios(usuarios);
    }

    public void serializarFavorito(JSONObject jsonObject) throws JSONException {
        List<Favorito> favoritos= new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            String usuario=car.getString("usuario");
            String descripcion=car.getString("descripcion");
            Favorito f= new Favorito(usuario,descripcion);
            favoritos.add(f);
        }
        model.setFavoritos(favoritos);
    }
    public void serializarPeligenero(JSONObject jsonObject) throws JSONException {
        List<Genero> generos= new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            String usuario= car.getString("usuario");
            String pelicula= car.getString("pelicula");
            Genero genero= new Genero(usuario,pelicula);
            generos.add(genero);
        }
        model.setGeneros(generos);
    }


    public void cargarFavoritos(){
        String apiUrl = "http://"+ LoginController.getInstance().host+":"+ LoginController.getInstance().puerto+"/Wiki_Server/BusquedaDatos?action=favoritos";
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                serializarFavorito(jsonObject);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }}
    public void cargarPeliGeneros(){
        String apiUrl = "http://"+LoginController.getInstance().host+":"+LoginController.getInstance().puerto+"/Wiki_Server/BusquedaDatos?action=generos";
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                serializarPeligenero(jsonObject);
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
    }


    public void cargarAplicacion(){
        if(!model.isCargado()){
            cargarFavoritos();
            cargarPeliGeneros();
        }

    }

    public boolean addUsuario(Usuario al){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+LoginController.getInstance().host+":"+LoginController.getInstance().puerto+"/Wiki_Server/createUser?nombre="+
                al.getNombre()+"&apellidos="+
                al.getApellidos()+"&edad="+al.getEdad()+
                "&sexo="+al.getSexo()+
                "&key="+al.getPassword()+
                "&email="+al.getEmail();
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                res= respuesta;
                USER=al;
                existeUsuario=false;
            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public void cargarGenerosXUsuario(String email){
        String apiUrl = "http://"+LoginController.getInstance().host+":"+LoginController.getInstance().puerto+"/Wiki_Server/findAllWiki?email="+email;
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                List<Genero> generos= new ArrayList<>();
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
                for(int i=0; i< jsonArray.length();i++){
                    JSONObject car= jsonArray.getJSONObject(i);
                    String descripcion =car.getString("descripcion");
                    Genero matricula= new Genero(email,descripcion);
                    generos.add(matricula);
                }
                USER.setGenerosPelis(generos);

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
    }
    public boolean addGeneros(List<String> generos){
        boolean respuesta=false;
        for(String g : generos){
            if(!addGenero(g)){
                respuesta=false;
                break;
            }else{
                respuesta=true;
            }
        }
        return respuesta;
    }
    public boolean addGenero(String g){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+LoginController.getInstance().host+":"+LoginController.getInstance().puerto+"/Wiki_Server/createWiki?email="+
                USER.getEmail()+"&descrip="+
                g;
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean deleteGeneros(){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+LoginController.getInstance().host+":"+LoginController.getInstance().puerto+"/Wiki_Server/deleteGenr?email="+
                USER.getEmail();
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean actualizarUsuario(Usuario al){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+LoginController.getInstance().host+":"+LoginController.getInstance().puerto+"/Wiki_Server/updateUser?nombre="+
                al.getNombre()+"&apellidos="+
                al.getApellidos()+"&edad="+al.getEdad()+
                "&sexo="+al.getSexo()+
                "&key="+al.getPassword()+
                "&email="+al.getEmail();
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                res= respuesta;
                USER=al;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public void actualizarFavorito(String username){

    }
    public void actualizarGenero(String username){

    }
    public void deleteUsuario(int ced){

    }
    public void deleteFavorito(int ced){

    }
    public void deleteGenero(int ced){

    }
}
