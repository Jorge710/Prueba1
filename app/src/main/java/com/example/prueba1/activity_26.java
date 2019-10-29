package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class activity_26 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_26);
    }

    public void ejecutarMusica(View v) {
        MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource("https://solotrap.com/full/Grupo%20Niche%20-%20Gotas%20de%20lluvia%20(www.Fuleteo.co).mp3?_=1");
            mp.prepare();
            mp.start();
        } catch (IOException e) {
        }
    }
}
