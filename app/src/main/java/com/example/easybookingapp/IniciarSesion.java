package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class IniciarSesion extends AppCompatActivity {

    ImageView imageViewUserIngreso, imageViewContra, imageViewUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);


        imageViewUserIngreso = findViewById(R.id.imageView_IniSesion);
        Picasso.with(this)
                .load("https://i.ibb.co/4jT8WqN/imagen-Inicio.png")
                .resize(400,400)
                .into(imageViewUserIngreso);

        imageViewUsu = findViewById(R.id.imageView_user1);
        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imageViewUsu);


        imageViewContra = findViewById(R.id.imageView_contra1);
        Picasso.with(this)
                .load("https://i.ibb.co/C90h8Hf/llave.png")
                .into(imageViewContra);



    }




    public void IrInicio(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

        public void Ingresar(View view){
        Intent i = new Intent(this, Inicio.class);
        startActivity(i);
    }

    public void Crear(View view){
        Intent i = new Intent(this, CreacionCuenta.class);
        startActivity(i);
    }


}