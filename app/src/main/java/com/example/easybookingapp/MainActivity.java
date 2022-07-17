package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imagenFondo = findViewById(R.id.ViewImagenInicio);
        Picasso.with(this)
                .load("https://i.ibb.co/RCF4g41/FLOGIN.jpg")
                .resize(1100,600)
                .into(imagenFondo);
    }

    public void IrSiguiente(View view){
        Intent i = new Intent(this, Inicio.class);
        startActivity(i);
    }

    public void Estar(View view){
        Intent e = new Intent(this, MainActivity.class);
        startActivity(e);
    }
}