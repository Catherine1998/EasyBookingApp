package com.example.easybookingapp.io;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EasyBookingAdapter {
    
    private static EasyBookingService API_SERVICE;

    public static EasyBookingService getApiService(){

        String urlApi = "https://tvjbapbmbi.execute-api.us-west-2.amazonaws.com/Prod/";
        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(urlApi)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API_SERVICE = retrofit.create(EasyBookingService.class);
        }

        return API_SERVICE;
    }

    
}
