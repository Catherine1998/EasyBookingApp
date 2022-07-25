package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreacionCuenta extends AppCompatActivity {

    ImageView imageViewNombre, imageViewApellido, imageViewDate, imageViewCorreo, imageViewContra, imageViewConfiContra;
    EditText fechaCampo;
    Calendar calendario;

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

        fechaCampo = findViewById(R.id.txtfecha);
        Calendar calendario = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener fecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendario.set(Calendar.YEAR, year);
                calendario.set(Calendar.MONTH, month);
                calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateCalendar();
            }

            private void updateCalendar() {
                String Format = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);
                fechaCampo.setText(sdf.format(calendario.getTime()));
            }
        };
        fechaCampo.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                new DatePickerDialog(CreacionCuenta.this, fecha, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH))
                        .show();

            }
        });

    }


    public void IrInicio(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void IrIniciarSession(View view) {
        Intent u = new Intent(this, IniciarSesion.class);
        startActivity(u);
    }


}