package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.squareup.picasso.Picasso;

public class Reservacion extends AppCompatActivity {

    ImageView imagenUser,mesa1,mesa2,mesa3,mesa4,mesa5, regresar;
   private Button btnReservar, btnLiberar;
   private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion);

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


        btnReservar = (Button) findViewById(R.id.btnElegirMesa);
        mensaje = (TextView) findViewById(R.id.idAlertTextView);
        btnLiberar= (Button) findViewById(R.id.btnLiberarMesa);

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Reservacion.this);

                builder.setCancelable(true);
                builder.setTitle("Confirmación");
               builder.setMessage("¿Desea Confirmar la reservación?");
               builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.cancel();
                   }
               });
               builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       AlertDialog.Builder builder1 = new AlertDialog.Builder(Reservacion.this);
                       builder1.setTitle("Confirmación Exitosa");
                       builder1.setIcon(R.drawable.controlar);
                       builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.cancel();
                           }
                       });
                       builder1.show();
                   }
               });
                builder.show();
            }
        });

        btnLiberar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Reservacion.this);

                builder.setCancelable(true);
                builder.setTitle("Cancelación");
                builder.setMessage("¿Desea liberar la mesa?");
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Reservacion.this);
                        builder1.setTitle("Liberación Exitosa");
                        builder1.setIcon(R.drawable.controlar);
                        builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder1.show();
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

    public void CierreSesion(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}