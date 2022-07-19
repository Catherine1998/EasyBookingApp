package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

public class lugar extends AppCompatActivity {

    ImageView imagenUser, foto,regresar;
    Spinner cambiarImagen;
    int imagen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);

        cambiarImagen = (Spinner) findViewById(R.id.spinner);
        imagenUser = findViewById(R.id.usuario);
        foto = findViewById(R.id.terraza);

        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imagenUser);

        cambiarImagen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                imagen = parent.getSelectedItemPosition();
                switch(imagen) {
                    case 0:
                        Picasso.with(parent.getContext())
                                .load("https://i.ibb.co/R7VfBrT/imagen.png")
                                .into(foto);
                        break;
                    case 1:
                        Picasso.with(parent.getContext())
                                .load("https://i.ibb.co/Qn0L6ph/restaurant-Terraz.png")
                                .into(foto);
                        break;
                    case 2:
                        Picasso.with(parent.getContext())
                                .load("https://i.ibb.co/cyK0b00/jardin.jpg")
                                .into(foto);
                        break;
                    case 3:
                        Picasso.with(parent.getContext())
                                .load("https://i.ibb.co/J7GQfFL/posada-rodrigo-planta-baja.jpg")
                                .into(foto);
                        break;
                    case 4:
                        Picasso.with(parent.getContext())
                                .load("https://i.ibb.co/wBwprcc/planta-alta.jpg")
                                .into(foto);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                Picasso.with(parent.getContext())
                        .load("https://i.ibb.co/R7VfBrT/imagen.png")
                        .into(foto);
            }
        });

            Picasso.with(this)
                    .load("https://i.ibb.co/R7VfBrT/imagen.png")
                    .into(foto);


        regresar = findViewById(R.id.RegresarLugar);
        Picasso.with(this)
                .load("https://i.ibb.co/Hgd4c25/hacia-atras.png")
                .into(regresar);
    }
    public void RegresarAlLugar(View view){
        Intent i = new Intent(this, Inicio.class);
        startActivity(i);
    }

    public void SeleccionarMesa(View view){
        Intent i = new Intent(this, Reservacion.class);
        startActivity(i);
    }


}