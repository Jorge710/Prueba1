package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
        final String user2="Omar";
        final String pasw ="1234";

        final Button boton = (Button) findViewById(R.id.btnLogin);
        boton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view){
                String usuario = ((EditText) findViewById(R.id.et1)).getText().toString();
                String password = ((EditText) findViewById(R.id.et2)).getText().toString();
                if (usuario.equals("izajorge7@gmail.com") && password.equals("123")){
                    abrirAPP();
                }else if(usuario.equals(user2) && password.equals(pasw)){
                    abrirAPP();
                } else{
                    Toast.makeText(boton.getContext(), "Usuario Incorrecto o clave incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void abrirAPP(){
        Intent nuevo = new Intent(activity_Login.this,activity_proyecto.class);
        startActivity(nuevo);
    }
}
