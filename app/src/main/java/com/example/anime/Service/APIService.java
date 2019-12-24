package com.example.anime.Service;

public class APIService {

    private static String base_url = "https://animemusicapp.herokuapp.com/api/";

    public static  Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }

}
