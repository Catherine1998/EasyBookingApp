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
    RadioButton rdHora1, rdHora2, rdHora3, rdHora4, rdHora5;
    Spinner cambiarImagenHorario;
    int imagenHorario = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        calendario = findViewById(R.id.calendarHorario);
        imagenUser = findViewById(R.id.userHorario);
        foto = findViewById(R.id.jornadaView);
        rdHora1 = findViewById(R.id.chkHora1);
        rdHora2 = findViewById(R.id.chkHora2);
        rdHora3 = findViewById(R.id.chkHora3);
        rdHora4 = findViewById(R.id.chkHora4);
        rdHora5 = findViewById(R.id.chkHora5);



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
                    rdHora1.setText("De 7:00 a 8:00");
                    rdHora2.setText("De 8:00 a 9:00");
                    rdHora3.setText("De 9:00 a 10:00");
                    rdHora4.setText("De 10:00 a 11:00");
                    rdHora5.setText("De 11:00 a 12:00");

                    break;
               case 1:
                    Picasso.with(parent.getContext())
                            .load("https://i.ibb.co/4fZH5kB/atardecer.png")
                            .into(foto);
                       rdHora1.setText("De 12:00 a 1:00");
                       rdHora2.setText("De 1:00 a 2:00");
                       rdHora3.setText("De 2:00 a 3:00");
                       rdHora4.setText("De 4:00 a 5:00");
                       rdHora5.setText("De 5:00 a 6:00");
                    break;
                case 2:
                    Picasso.with(parent.getContext())
                            .load("https://i.ibb.co/WPphdrR/noche2.jpg")
                            .into(foto);
                        rdHora1.setText("De 6:00 a 7:00");
                        rdHora2.setText("De 7:00 a 8:00");
                        rdHora3.setText("De 8:00 a 9:00");
                        rdHora4.setText("De 9:00 a 10:00");
                        rdHora5.setText("De 10:00 a 11:00");
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

    public void CierreSesion(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void IrReserva(View view) {
        Intent intent = new Intent(this, Reservacion.class);
        startActivity(intent);
    }

}