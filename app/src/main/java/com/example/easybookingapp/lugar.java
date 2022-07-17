package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;


import com.squareup.picasso.Picasso;

public class lugar extends AppCompatActivity {

    ImageView imagenUser, imagenTerraza;
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


    }
}