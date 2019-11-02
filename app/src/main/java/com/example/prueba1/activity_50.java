package com.example.prueba1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class activity_50 extends AppCompatActivity {

    private ImageView imagen1;
    private EditText et1;

    private static final int TAKE_PICTURE = 0;
    public Uri imageUri;

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_50);

        imagen1=(ImageView)findViewById(R.id.imageView);
        et1=(EditText)findViewById(R.id.editText);


    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    String currentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public void tomarFoto(View v) {

        Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photo = new File(Environment.getExternalStorageDirectory(), et1.getText().toString());
        intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
        imageUri = Uri.fromFile(photo); //CAMBIAR

        try {
            startActivity(intento1);
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la cámara:"+e.toString(), Toast.LENGTH_SHORT).show();
            Log.e("Cámara ", e.toString());
        }

          /*Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        */

    }

    public void recuperarFoto(View v) {
        Bitmap bitmap1 = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+et1.getText().toString());
        imagen1.setImageBitmap(bitmap1);
    }

    public void ver(View v) {
        Intent intento1=new Intent(this,Actividad2.class);
        startActivity(intento1);
    }
}
