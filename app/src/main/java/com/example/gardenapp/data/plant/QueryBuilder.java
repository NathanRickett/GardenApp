package com.example.gardenapp.data.plant;


public class QueryBuilder {
    private final String apiKey = "Vyuv9wOR6bu0HPBdxfyiUAy4bmQ0YJDBun6vaBeQSek";
    private final String baseURL = "https://trefle.io/api/v1";


    public QueryBuilder() {

    }

    public String getQueryURL(boolean doesMatch, String searchTarget, String filterKey, String[] filterValues) {
        return appendArgs(doesMatch, searchTarget, filterKey, filterValues);
    }


    //appends arguments to the url for searching
    //returns the new URL to use for the query
    private String appendArgs(Boolean doesMatch, String searchTarget, String filterKey, String[] filterValues) {
        String queryURL = baseURL;

        queryURL += "/" + searchTarget +"?";
        queryURL += "token=" + apiKey;

        if (doesMatch) {
            queryURL += "&filter[" + filterKey + "]=";
        }
        else {
            queryURL += "&filter_not[" + filterKey + "]=";
        }

        for (int i = 0; i < filterValues.length  ; ++i) {
            if (i == 0) {
                queryURL += filterValues[i];
            }
            else {
                queryURL += "," + filterValues[i];
            }
        }

        return queryURL;
    }
}
