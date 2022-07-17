package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

import com.squareup.picasso.Picasso;

public class horario extends AppCompatActivity {

    ImageView imagenUser, foto, calendario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        calendario = findViewById(R.id.calendarHorario);
        imagenUser = findViewById(R.id.userHorario);

        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imagenUser);

        Picasso.with(this)
                .load("https://i.ibb.co/THmrzJT/calendario.png")
                .into(calendario);

    }
}