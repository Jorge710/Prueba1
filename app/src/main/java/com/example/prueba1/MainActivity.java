package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void activity13(View view){
        Intent act13 = new Intent(this, activity_13.class);
        startActivity(act13);
    }

    public void activity24(View view){
        Intent act24 = new Intent(this, activity_24.class);
        startActivity(act24);
    }
}
