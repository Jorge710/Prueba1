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

    public void activity26(View view){
        Intent act26 = new Intent(this, activity_26.class);
        startActivity(act26);
    }

    public void activity35(View view){
        Intent act35 = new Intent(this, activity_35.class);
        startActivity(act35);
    }

    public void activity39(View view){
        Intent act39 = new Intent(this, activity_39.class);
        startActivity(act39);
    }
}
