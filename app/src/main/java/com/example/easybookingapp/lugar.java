package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;


import com.squareup.picasso.Picasso;

public class lugar extends AppCompatActivity {

    ImageView imagenUser, imagenTerraza,imagenHome,imagenSearch,imagenSave,imagenNoti;
    Spinner cambiarImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);

        imagenUser = findViewById(R.id.usuario);
        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imagenUser);

        imagenTerraza = findViewById(R.id.terraza);
        Picasso.with(this)
                .load("https://i.ibb.co/Qn0L6ph/restaurant-Terraz.png")
                .into(imagenTerraza);

        imagenHome = findViewById(R.id.homeLugar);
        Picasso.with(this)
                .load("https://i.ibb.co/wRDhYCg/hogar.png")
                .into(imagenHome);

        imagenSearch = findViewById(R.id.buscarLugar);
        Picasso.with(this)
                .load("https://i.ibb.co/jMwm6CK/search.png")
                .into(imagenSearch);

        imagenSave = findViewById(R.id.guardarLugar);
        Picasso.with(this)
                .load("https://i.ibb.co/W5cn0bj/save.png")
                .into(imagenSave);

        imagenNoti = findViewById(R.id.notiLugar);
        Picasso.with(this)
                .load("https://i.ibb.co/pK63PH4/bell.png")
                .into(imagenNoti);

    }
}