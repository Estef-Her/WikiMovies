package com.example.wikimovies.Utils;

import android.os.AsyncTask;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class httpRequester extends AsyncTask<JSONObject, String, Object> {

    public final static int POST = 1;
    public final static int GET = 2;
    public final static int PUT = 3;
    public final static int DELETE = 4;

    private static final String HEADER_TYPE = "application/json";


    @Override
    protected Object doInBackground(JSONObject... jsonObjects) {

        try {
            return realizaLlamadoHttp(jsonObjects[0].getString("data"), jsonObjects[0].getString("url"), jsonObjects[0].getInt("tipo"));

        } catch (Exception e) {
            e.printStackTrace();
            org.json.simple.JSONObject salida = new org.json.simple.JSONObject();
            salida.put("mensaje", e.getMessage());
            salida.put("tipo", "Error");
            return salida;


        }

    }


    private Object realizaLlamadoHttp(String params, String url, int tipoLlamado) throws IOException, ParseException, JSONException {
        org.json.simple.JSONObject salida = new org.json.simple.JSONObject();
        HttpClient client = new DefaultHttpClient();
        HttpParams httpParams= client.getParams();
        HttpConnectionParams.setConnectionTimeout(httpParams,3*1000);
        HttpConnectionParams.setSoTimeout(httpParams,3*1000);


        StringEntity entity = new StringEntity(params);

        Object tipo_request = null;
        switch (tipoLlamado) {
            case POST: {
                HttpPost aux = new HttpPost(url);
                aux.setEntity(entity);
                aux.setHeader("Accept", HEADER_TYPE);
                aux.setHeader("Content-type", HEADER_TYPE);
                tipo_request = aux;
            }
            break;
            case GET: {
                HttpGet aux = new HttpGet(url);
                aux.setHeader("Accept", HEADER_TYPE);
                aux.setHeader("Content-type", HEADER_TYPE);
                tipo_request = aux;
            }
            break;
            case PUT: {
                HttpPut aux = new HttpPut(url);
                aux.setEntity(entity);
                aux.setHeader("Accept", HEADER_TYPE);
                aux.setHeader("Content-type", HEADER_TYPE);
                tipo_request = aux;
            }
            break;
            case DELETE: {
                HttpDelete aux = new HttpDelete(url);
                aux.setHeader("Accept", HEADER_TYPE);
                aux.setHeader("Content-type", HEADER_TYPE);
                tipo_request = aux;
            }
        }


        HttpResponse response = client.execute((HttpUriRequest) tipo_request);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity1 = response.getEntity();
            return JsonParser.parseResponse(entity1.getContent());


        } else {
            salida.put("tipo", "Error");
            salida.put("mensaje", response.getStatusLine().getReasonPhrase());
        }
        return salida;
    }


}
