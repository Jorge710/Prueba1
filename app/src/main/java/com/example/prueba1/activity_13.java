package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity_13 extends AppCompatActivity {
    private EditText et1;
    private EditText et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_13);

        //primero
        et1=(EditText)findViewById(R.id.et1);
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(prefe.getString("mail",""));

        //segundo
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
    }

    public void ejecutar(View view) {
        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("mail", et1.getText().toString());
        editor.commit();
        finish();
    }

    public void grabar(View view) {
        String nombre=et2.getText().toString();
        String datos=et3.getText().toString();
        SharedPreferences preferencias=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString(nombre, datos);
        editor.commit();
        Toast.makeText(this,"Datos grabados", Toast.LENGTH_LONG).show();
    }

    public void recuperar(View view) {
        String nombre=et2.getText().toString();
        SharedPreferences prefe=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String d=prefe.getString(nombre, "");
        if (d.length()==0) {
            Toast.makeText(this,"No existe dicho nombre en la agenda", Toast.LENGTH_LONG).show();
        }
        else {
            et3.setText(d);
        }
    }
}
