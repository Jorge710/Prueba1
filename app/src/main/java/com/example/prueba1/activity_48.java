package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class activity_48 extends AppCompatActivity {

    private ArrayList<String> telefonos;
    private ArrayAdapter<String> adaptador1;
    private ListView lv1;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_48);
        telefonos=new ArrayList<String>();
        telefonos.add("Omar : 0961838029");
        telefonos.add("Jefferson : O979066684");
        telefonos.add("ana : 7445434");
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,telefonos);
        lv1=(ListView)findViewById(R.id.listView);
        lv1.setAdapter(adaptador1);

        et1=(EditText)findViewById(R.id.editText);

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(activity_48.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este número de teléfono ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        telefonos.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
    }

    public void agregar(View v) {
        if(et1.getText().toString().equals("")){
            System.out.println("Ingrese el nombre y número de télefono!");
            String titulo = "No se puede guardar";
            String mensajeAlerta= "Debe ingresar un nombre y número de teléfono para guardar.";
            alerta(titulo,mensajeAlerta);
        }else {
            telefonos.add(et1.getText().toString());
            adaptador1.notifyDataSetChanged();
            et1.setText("");
        }
    }

    /**
     * Mensaje en pantalla que desaparece tras pulsar Atras
     //* @param String cadena
     */
    public void alerta(String titulo, String cadena) {
        //se prepara la alerta creando nueva instancia
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        //seleccionamos la cadena a mostrar
        dialogBuilder.setMessage(cadena);
        //elegimo un titulo y configuramos para que se pueda quitar
        dialogBuilder.setCancelable(true).setTitle(titulo);
        //mostramos el dialogBuilder
        dialogBuilder.create().show();
    }
}
