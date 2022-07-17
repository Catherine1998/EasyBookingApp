package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CreacionCuenta extends AppCompatActivity {

    ImageView imageViewNombre, imageViewApellido, imageViewDate, imageViewCorreo, imageViewContra, imageViewConfiContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_cuenta);

        imageViewNombre = findViewById(R.id.imageView_nombre);
        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imageViewNombre);

        imageViewApellido = findViewById(R.id.imageView_apellido);
        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imageViewApellido);


        imageViewDate = findViewById(R.id.imageView_fecha);
        Picasso.with(this)
                .load("https://i.ibb.co/THmrzJT/calendario.png")
                .into(imageViewDate);

        imageViewCorreo = findViewById(R.id.imageView_correo);
        Picasso.with(this)
                .load("https://i.ibb.co/7K8q3J7/arroba.png")
                .into(imageViewCorreo);

        imageViewContra = findViewById(R.id.imageView_contra);
        Picasso.with(this)
                .load("https://i.ibb.co/C90h8Hf/llave.png")
                .into(imageViewContra);

        imageViewConfiContra = findViewById(R.id.imageView_contraconfi);
        Picasso.with(this)
                .load("https://i.ibb.co/C90h8Hf/llave.png")
                .into(imageViewConfiContra);


    }

    public void IrInicio(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}