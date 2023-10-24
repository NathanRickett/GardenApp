package com.example.gardenapp.data.plant;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class PlantAPIHandler {
    private final String apiKey = "Vyuv9wOR6bu0HPBdxfyiUAy4bmQ0YJDBun6vaBeQSek";
    private final String url = "https://trefle.io/api/v1/plants?token=" + apiKey;
    private QueryBuilder qBuilder;

    public PlantAPIHandler(){
        this.qBuilder = new QueryBuilder();
    }

    public JSONObject findPlantsByName(String commonName) {
        String[] filterValues = {commonName};
        return findPlants("common_name", filterValues);
    }

    private JSONObject findPlants(String filterKey, String[] filterValues) {
        String queryURL = qBuilder.getQueryURL(true, "plants", filterKey, filterValues);
        Log.d("abcd", "url used: " + queryURL);
        Request request = new Request(queryURL, "GET");
        request.start(); //starting new thread
        try {
            request.join();
            JSONObject obj = parseJSON(request.getResponse());
            return obj;
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public JSONObject findPlantsNot() {
        return null;
    }

    public JSONObject findSpecies() {
        return null;
    }

    public JSONObject findSpeciesNot() {
        return null;
    }


    private JSONObject parseJSON(String response) {
        try {
            JSONObject obj = new JSONObject(response);
            return obj;
        }
        catch(JSONException e) {
            //Log.d("abcd", e.getMessage());

        }
        return null;
    }

    public static int v(String tag, String message) {
        int _charLimit = 2000;

        // If the message is less than the limit just show
        if (message.length() < _charLimit) {
            return Log.v(tag, message);
        }
        int sections = message.length() / _charLimit;
        for (int i = 0; i <= sections; i++) {
            int max = _charLimit * (i + 1);
            if (max >= message.length()) {
                Log.v(tag, message.substring(_charLimit * i));
            } else {
                Log.v(tag, message.substring(_charLimit * i, max));
            }
        }
        return 1;
    }

    private class Request extends Thread {

        private String response;
        private String queryURL;
        private String requestMethod;


        public Request(String queryURL, String requestMethod) {
            this.queryURL = queryURL;
            this.requestMethod = requestMethod;
        }
        public void run() {
            try {
                this.response = sendRequest(queryURL, requestMethod);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }



        private String sendRequest(String queryURL, String requestMethod) throws Exception {
            //TODO append args to the get request in sendGetRequest method

            StringBuilder result = new StringBuilder();
            URL url = new URL(queryURL);
            Log.d("abcd", "made url object");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            Log.d("abcd", "made httpsURLConnection");
            conn.setRequestMethod(requestMethod);
            Log.d("abcd", "Set request method to GET");
            int responseCode = conn.getResponseCode();
            Log.d("abcd", "response code: " + responseCode);
            if (responseIsGood(responseCode)) {
                Log.d("abcd", "response code is good");
            }

            else {
                Log.d("abcd", "response code is bad with URL " + this.queryURL);
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
            catch(Exception e) {

            }
            if (result == null) {
                Log.d("abcd", "null get request string");
            }
            return result.toString();
        }

        private boolean responseIsGood(int responseCode) {
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return true;
            }
            return false;
        }

        public String getResponse() {
            return this.response;
        }
    }

}
