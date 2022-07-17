package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.view.View;
import com.squareup.picasso.Picasso;

public class Inicio extends AppCompatActivity {

    ImageView imagenUser, imagenHome, imagenSearch, imagenSave, imagenNoti, imagenR1, imagenR2, imagenR3, imagenR4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        imagenUser = findViewById(R.id.imageView_user);
        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imagenUser);

        imagenHome = findViewById(R.id.imageView_home);
        Picasso.with(this)
                .load("https://i.ibb.co/wRDhYCg/hogar.png")
                .into(imagenHome);

        imagenSearch = findViewById(R.id.imageView_search);
        Picasso.with(this)
                .load("https://i.ibb.co/jMwm6CK/search.png")
                .into(imagenSearch);

        imagenSave = findViewById(R.id.imageView_save);
        Picasso.with(this)
                .load("https://i.ibb.co/W5cn0bj/save.png")
                .into(imagenSave);

        imagenNoti = findViewById(R.id.imageView_bell);
        Picasso.with(this)
                .load("https://i.ibb.co/pK63PH4/bell.png")
                .into(imagenNoti);


        imagenR1 = findViewById(R.id.imageView_R1);
        Picasso.with(this)
                .load("https://i.ibb.co/N1Yj7qW/res4.png")
                .resize(550,500)
                .into(imagenR1);

        imagenR2 = findViewById(R.id.imageView_R2);
        Picasso.with(this)
                .load("https://i.ibb.co/8mnKPzc/res3.png")
                .resize(550,500)
                .into(imagenR2);


        imagenR3 = findViewById(R.id.imageView_R3);
        Picasso.with(this)
                .load("https://i.ibb.co/bJQxVtQ/res2.png")
                .resize(550,500)
                .into(imagenR3);

        imagenR4 = findViewById(R.id.imageView_R4);
        Picasso.with(this)
                .load("https://i.ibb.co/SrG02b9/res1.png")
                .resize(550,500)
                .into(imagenR4);

    }
    public void IrAlLugar(View view){
        Intent i = new Intent(this, lugar.class);
        startActivity(i);
    }

    public void IrHorario(View view){
        Intent i = new Intent(this, horario.class);
        startActivity(i);
    }
}