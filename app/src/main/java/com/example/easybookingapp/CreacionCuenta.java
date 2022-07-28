package com.example.easybookingapp;

import static android.R.color.black;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.colorSpace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreacionCuenta extends AppCompatActivity {

    ImageView imageViewNombre, imageViewApellido, imageViewDate, imageViewCorreo, imageViewContra, imageViewConfiContra;
    EditText fechaCampo, nombreUsuario, apellidoUsuario, correoUsuario, contraUsuario, confirmarContra;
    String nombreU, correoU, contraU, fechaU, confirmarContraU, apellidoU;
    Button btnCreacionCuenta;
    CheckBox CheckAceptado;
    Calendar calendario;

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
                new DatePickerDialog(CreacionCuenta.this, fecha, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH))
                        .show();
            }
        });

        nombreUsuario = findViewById(R.id.txtnombre);
        correoUsuario = findViewById(R.id.txtemail);
        contraUsuario = findViewById(R.id.txtpassword);
        confirmarContra = findViewById(R.id.txtconfirmPass);
        btnCreacionCuenta = findViewById(R.id.btnCrearCuenta);
        apellidoUsuario = findViewById(R.id.txtapellido);
        cargando = findViewById(R.id.progressBar);
        CheckAceptado = findViewById(R.id.checkBox_aceptar);

        btnCreacionCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombreU = nombreUsuario.getText().toString() + " " + apellidoUsuario.getText().toString();
                correoU = correoUsuario.getText().toString();
                confirmarContraU = confirmarContra.getText().toString();
                fechaU = fechaCampo.getText().toString();
                contraU = contraUsuario.getText().toString();
                apellidoU = apellidoUsuario.getText().toString();
                cargando = findViewById(R.id.progressBar);

                Pattern pattern = Patterns.EMAIL_ADDRESS;

                if (!pattern.matcher(correoU).matches()) {
                    Toast.makeText(getApplicationContext(), "Ingrese un correo válido", Toast.LENGTH_LONG).show();
                    return;
                }

                if (nombreU.isEmpty() || apellidoU.isEmpty() || correoU.isEmpty() || contraU.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_LONG).show();
                    return;
                }
                if (confirmarContraU.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Confirme la contraseña", Toast.LENGTH_LONG).show();
                    return;
                }
                if (contraU.length() < 8) {
                    Toast.makeText(getApplicationContext(), "La contraseña debe tener un mínimo de 8 carácteres.", Toast.LENGTH_LONG).show();
                }
                if (contraU.equals(confirmarContraU)) {

                    if (CheckAceptado.isChecked()) {

                        metodoCreacion(nombreU, fechaU, correoU, contraU);

                    } else {
                        Toast.makeText(getApplicationContext(), "Acepte los términos", Toast.LENGTH_LONG).show();
                        return;
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                    return;
                }

            }
        });

    }


    public void IrIniciarSession() {
        Intent u = new Intent(CreacionCuenta.this, IniciarSesion.class);
        startActivity(u);
    }


    private void metodoCreacion(String nombreUsuario, String fechaUsuario, String correoUsuario, String contraUsuario) {

        cargando.setVisibility(View.VISIBLE);

        Usuario User = new Usuario(nombreUsuario, fechaUsuario, correoUsuario, contraUsuario);
        Call<Usuario> call = EasyBookingAdapter.getApiService().creacionUser(User);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        Toast.makeText(CreacionCuenta.this, "Usuario Creado", Toast.LENGTH_SHORT).show();
                        cargando.setVisibility(View.GONE);
                        IrIniciarSession();

                    }
                } else {
                    cargando.setVisibility(View.GONE);
                    try {
                        String error = response.errorBody().string();
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });


    }

    public void RegresarInicioSesion(View view) {
        Intent i = new Intent(this, IniciarSesion.class);
        startActivity(i);
    }

}