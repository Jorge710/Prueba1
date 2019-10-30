package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class activity_39 extends AppCompatActivity {

    private int corx, cory;
    String accion = "accion";
    private Lienzo fondo;
    Path path = new Path();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_39);

        corx = 100;
        cory = 100;
        RelativeLayout layout1 = findViewById(R.id.layout1);
        fondo = new Lienzo(this);
        layout1.addView(fondo);
    }

    public boolean onTouchEvent( MotionEvent event) {
        corx = (int) event.getX();
        cory = (int) event.getY();
        cory = cory-150;

        if(event.getAction()== MotionEvent.ACTION_DOWN) {
            accion = "down";
        }
        if(event.getAction()== MotionEvent.ACTION_MOVE) {
            accion = "move";
        }
        fondo.invalidate();
        return true;
    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            //COLOR DE FONDO DIBUJAR UN CIRCULO
            canvas.drawRGB(16, 182, 215);
            Paint pincel1 = new Paint();
            //COLOR DE CIRCUNFERENCIA
            pincel1.setARGB(255, 255, 0, 0);
            pincel1.setStrokeWidth(4);
            pincel1.setStyle(Paint.Style.STROKE);

            //canvas.drawCircle(corx, cory, 20, pincel1);
            if(accion.equals("down")){
                path.moveTo(corx,cory);
                System.out.println("coordenada X: "+corx);
                System.out.println("coordenada y: "+(cory));
            }else if(accion.equals("move")) {
                //canvas.drawCircle(corx, cory, 20, pincel1);
                path.lineTo(corx,cory);
                System.out.println("coordenada y en moviemiento: "+(cory));
            }
            canvas.drawCircle(corx, cory, 20, pincel1);
            System.out.println("Dibuja: X:" + corx+ "Dibuja y: "+cory);
        }
    }
}
