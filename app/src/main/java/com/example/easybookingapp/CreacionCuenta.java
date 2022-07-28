package com.example.easybookingapp;

import static android.R.color.black;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.colorSpace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.easybookingapp.Model.Usuario;
import com.example.easybookingapp.Model.login;
import com.example.easybookingapp.io.EasyBookingAdapter;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreacionCuenta extends AppCompatActivity {

    ImageView imageViewNombre, imageViewApellido, imageViewDate, imageViewCorreo, imageViewContra, imageViewConfiContra;
    EditText fechaCampo, nombreUsuario, correoUsuario, contraUsuario, confirUsuario;
    Calendar calendario;
    String nombreU, correoU,contraU, fechaU;
    Button btnCreacionCuenta;
    private ProgressBar cargando;

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
        calendario = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener fecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendario.set(Calendar.YEAR, year);
                calendario.set(Calendar.MONTH, month);
                calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateCalendar();

            }

            private void updateCalendar() {
                String Format = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);
                fechaCampo.setText(sdf.format(calendario.getTime()));
            }
        };
        fechaCampo.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                 new DatePickerDialog(CreacionCuenta.this,fecha, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH))
                        .show();
            }
        });


// DEFINICION DE VARIABLES
        nombreUsuario  = findViewById(R.id.txtnombre);
        correoUsuario = findViewById(R.id.txtemail);
        contraUsuario = findViewById(R.id.txtpassword);
        confirUsuario = findViewById(R.id.txtconfirmPass);
        btnCreacionCuenta = findViewById(R.id.btnCrearCuenta);
        cargando = findViewById(R.id.progressBar);

//
        btnCreacionCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Realizar validaciones
                    //confirm pass y pass iguales
                // campos llenos
                // validacion de email
                //checkbox chequeado
// recibo info

                nombreU = nombreUsuario.getText().toString();
                correoU = correoUsuario.getText().toString();
                fechaU = "1990-09-12";
                contraU = contraUsuario.getText().toString();
                cargando = findViewById(R.id.progressBar);


                 //   Toast.makeText(getApplicationContext(), fechaU, Toast.LENGTH_SHORT).show();


                // metodo de creacion
                metodoCreacion(nombreU,fechaU,correoU,contraU);


            }
        });

    }

    public void IrInicio(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void IrIniciarSession() {
        Intent u = new Intent(CreacionCuenta.this, IniciarSesion.class);
        startActivity(u);
    }


    private void metodoCreacion(String nombreUsuario,String fechaUsuario, String correoUsuario, String contraUsuario ) {

        cargando.setVisibility(View.VISIBLE);

        Usuario User = new Usuario(nombreUsuario,fechaUsuario,correoUsuario, contraUsuario);
        Call<Usuario> call = EasyBookingAdapter.getApiService().creacionUser(User);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        Toast.makeText(CreacionCuenta.this, "Usuario Creado", Toast.LENGTH_SHORT).show();
                        cargando.setVisibility(View.GONE);
                        IrIniciarSession();

                        //BORRADO DE CAMPOS CON .SET TEXT("");
                    }
                } else {
                    cargando.setVisibility(View.GONE);
                    try {




                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        String errorMsg = jObjError.getString("errorMessage");
                      String  msjNuevo = errorMsg.replace("Value","");
                       msjNuevo = errorMsg.replace("of type java.lang.String cannot be converted to JSONObject","");


                        Toast.makeText(getApplicationContext(), msjNuevo, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }



                    //BORRADO DE CAMPOS CON .SET TEXT("");
                  //  Toast.makeText(CreacionCuenta.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                   // Toast.makeText(getApplicationContext(), "Error Al crear usuario", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });


    }

}