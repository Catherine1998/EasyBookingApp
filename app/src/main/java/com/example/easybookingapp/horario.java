package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class horario extends AppCompatActivity {

    ImageView imagenUser, calendario,foto;
    Spinner cambiarImagenHorario;
    int imagenHorario = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        calendario = findViewById(R.id.calendarHorario);
        imagenUser = findViewById(R.id.userHorario);
        foto = findViewById(R.id.jornadaView);
        cambiarImagenHorario = (Spinner) findViewById(R.id.spnJornadas);
        cambiarImagenHorario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
            imagenHorario = parent.getSelectedItemPosition();
            switch(imagenHorario) {
                case 0:
                    Picasso.with(parent.getContext())
                            .load("https://i.ibb.co/3vcD18L/dia.jpg")
                            .into(foto);

                    break;
               case 1:
                    Picasso.with(parent.getContext())
                            .load("https://i.ibb.co/4fZH5kB/atardecer.png")
                            .into(foto);
                    //R.string.lblHora1 = "De 1:00 a 2:00";
                    break;
                case 2:
                    Picasso.with(parent.getContext())
                            .load("https://i.ibb.co/WPphdrR/noche2.jpg")
                            .into(foto);
                    break;
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
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imagenUser);

        Picasso.with(this)
                .load("https://i.ibb.co/THmrzJT/calendario.png")
                .into(calendario);


    }
}