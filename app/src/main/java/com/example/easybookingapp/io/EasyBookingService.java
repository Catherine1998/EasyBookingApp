package com.example.easybookingapp.io;


import com.example.easybookingapp.Model.login;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface EasyBookingService {

    @POST("api/Usuarios/Login")
    Call<login> loginUser(@Body login datosLogin);
}
