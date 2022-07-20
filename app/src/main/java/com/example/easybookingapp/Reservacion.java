package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Reservacion extends AppCompatActivity {

    ImageView imagenUser,mesa1,mesa2,mesa3,mesa4,mesa5, regresar;
    private Button btnReservar;
    private TextView txtReservar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion);

        btnReservar = (Button) findViewById(R.id.btnElegirMesa);
        txtReservar = (TextView)findViewById(R.id.idAlertTextView);

        imagenUser = findViewById(R.id.usuarioReserva);
        regresar = findViewById(R.id.regresarReserva);
        mesa1 = findViewById(R.id.mesa1);
        mesa2 = findViewById(R.id.mesa2);
        mesa3 = findViewById(R.id.mesa3);
        mesa4 = findViewById(R.id.mesa4);
        mesa5 = findViewById(R.id.mesa5);

        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imagenUser);

        Picasso.with(this)
                .load("https://i.ibb.co/Hgd4c25/hacia-atras.png")
                .into(regresar);

        Picasso.with(this)
                .load("https://i.ibb.co/vhfzTJ7/Mesa.png")
                .into(mesa1);
        Picasso.with(this)
                .load("https://i.ibb.co/vhfzTJ7/Mesa.png")
                .into(mesa2);
        Picasso.with(this)
                .load("https://i.ibb.co/vhfzTJ7/Mesa.png")
                .into(mesa3);
        Picasso.with(this)
                .load("https://i.ibb.co/vhfzTJ7/Mesa.png")
                .into(mesa4);
        Picasso.with(this)
                .load("https://i.ibb.co/vhfzTJ7/Mesa.png")
                .into(mesa5);

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Reservacion.this);
                builder.setCancelable(true);
                builder.setTitle("¿Desea confirmar la recervación?");
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Mesa Confirmada",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
    public void Atras(View view){
        Intent i = new Intent(this, lugar.class);
        startActivity(i);
    }
}