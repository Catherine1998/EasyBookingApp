package com.example.easybookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.easybookingapp.Model.login;
import com.example.easybookingapp.io.EasyBookingAdapter;
import com.example.easybookingapp.io.EasyBookingService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IniciarSesion extends AppCompatActivity {

    ImageView imageViewUserIngreso, imageViewContra, imageViewUsu;
    private Button BotonInicio;
    private EditText txtContra, txtUsuario;
    private String usuario, password;
    private ProgressBar cargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);


        imageViewUserIngreso = findViewById(R.id.imageView_IniSesion);
        Picasso.with(this)
                .load("https://i.ibb.co/4jT8WqN/imagen-Inicio.png")
                .resize(400, 400)
                .into(imageViewUserIngreso);

        imageViewUsu = findViewById(R.id.imageView_user1);
        Picasso.with(this)
                .load("https://i.ibb.co/P6BB0Md/user.png")
                .into(imageViewUsu);


        imageViewContra = findViewById(R.id.imageView_contra1);
        Picasso.with(this)
                .load("https://i.ibb.co/C90h8Hf/llave.png")
                .into(imageViewContra);

        BotonInicio = findViewById(R.id.button15);
        txtContra = findViewById(R.id.editTextTextPersonName2);
        txtUsuario = findViewById(R.id.editTextTextPersonName);
        cargando = findViewById(R.id.progressBar);

        BotonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SessionManagement sessionManagement = new SessionManagement(IniciarSesion.this);
                int userName = sessionManagement.getSession();
                if(userName != -1){
                    IrPaginaPrincipal();
                }


                usuario = txtUsuario.getText().toString();
                password = txtContra.getText().toString();
                if (usuario.isEmpty() && password.isEmpty()) {
                    Toast.makeText(IniciarSesion.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
                    return;
                }
                metodoLogin(usuario, password);
            }
        });
    }


// se agrego


    @Override
    protected void onStart() {
        super.onStart();
        userLogeado();
    }

   private void userLogeado() {


        //revisa si el usuario esta logeado

        SessionManagement sessionManagement = new SessionManagement(IniciarSesion.this);
        int userName = sessionManagement.getSession();
        if(userName != -1){
            //logeado
            IrPaginaPrincipal();
        }
        else{


        }
    }

    private void metodoLogin(String usuario, String password) {

        cargando.setVisibility(View.VISIBLE);

        login loginUser = new login(usuario, password);
        Call<login> call = EasyBookingAdapter.getApiService().loginUser(loginUser);

        call.enqueue(new Callback<login>() {
            @Override
            public void onResponse(Call<login> call, Response<login> response) {

                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        login responseLogin = response.body();

                        String nombreUsuario = responseLogin.getNombre();
                        String bienvenida = "Bienvenido " + nombreUsuario;

                        Toast.makeText(IniciarSesion.this, bienvenida, Toast.LENGTH_SHORT).show();
                        cargando.setVisibility(View.GONE);
                        txtUsuario.setText("");
                        txtContra.setText("");

                        //save session
                        SessionManagement sessionManagement = new SessionManagement(IniciarSesion.this);
                        sessionManagement.saveSession(loginUser);
                        //move to principal
                        IrPaginaPrincipal();

                    }
                } else {
                    cargando.setVisibility(View.GONE);
                    txtUsuario.setText("");
                    txtContra.setText("");
                    Toast.makeText(getApplicationContext(), "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<login> call, Throwable t) {

            }
        });


    }

    public void IrPaginaPrincipal() {
        Intent i = new Intent(IniciarSesion.this, Inicio.class);
        //i.putExtra("nombre", nombreUsuario);
        startActivity(i);
    }


    public void IrInicio(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Crear(View view) {
        Intent i = new Intent(this, CreacionCuenta.class);
        startActivity(i);
    }


}