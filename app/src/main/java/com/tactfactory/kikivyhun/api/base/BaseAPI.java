package com.tactfactory.kikivyhun.api.base;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tactfactory on 13/04/17.
 */

public class BaseAPI<T extends EntityBase> {

    public BaseAPI(){

    }

    public static JSONObject getJSONObjectFromURL(String urlString) throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        System.out.println("JSON: " + jsonString);

        return new JSONObject(jsonString);
    }
// Legacy before Android 6.0

//    public static String GetHttpStringItem(String goTo) {
//        HttpClient client = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(goTo);
//        HttpResponse response;
//        try {
//            response = client.execute(httpGet);
//
//            ResponseHandler<String> handler = new BasicResponseHandler();
//            return handler.handleResponse(response);
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return null;
//    }
}
