package com.placesOfHistory.JsonSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
// first change check

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String request = "https://en.wikipedia.org/w/api.php?action=query&format=json&list=geosearch&gsradius=10000&gscoord=45.786971%7C-122.399677";
        String result = performRequest(request);
        
        Gson gson = new GsonBuilder().create();
        wikiRequestJson json = (wikiRequestJson) gson.fromJson(result, wikiRequestJson.class);
        
        for(SearchObject obj : json.query.geosearch){
        	System.out.println(obj);
        }
        
    }
    
    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } finally {
            http.disconnect();
        }

        return sb.toString();
    }
}
