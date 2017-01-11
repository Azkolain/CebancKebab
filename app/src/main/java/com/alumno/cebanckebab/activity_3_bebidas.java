package com.alumno.cebanckebab;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_3_bebidas extends AppCompatActivity{

    private String[] informacionUsuario;
    private ArrayList<String> listaPedido;
    private String[] arrayBebidas;

    private TextView tCantidadCocaCola;
    private TextView tCantidadKasLimon;
    private TextView tCantidadKasNaranja;
    private TextView tCantidadNestea;
    private TextView tCantidadCerveza;
    private TextView tCantidadAgua;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cebanc_kebab_3_bebidas);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));

        Bundle extras = getIntent().getExtras();
        informacionUsuario = extras.getStringArray("informacionUsuario");
        listaPedido = getIntent().getStringArrayListExtra("listaPedido");
        arrayBebidas = extras.getStringArray("arrayBebidas");

        tCantidadCocaCola = (TextView) findViewById(R.id.textCantidadCocaCola);
        tCantidadKasLimon = (TextView) findViewById(R.id.textCantidadKasLimon);
        tCantidadKasNaranja = (TextView) findViewById(R.id.textCantidadKasNaranja);
        tCantidadNestea = (TextView) findViewById(R.id.textCantidadNestea);
        tCantidadCerveza = (TextView) findViewById(R.id.textCantidadCerveza);
        tCantidadAgua = (TextView) findViewById(R.id.textCantidadAgua);
    }

    public void onClickSalir(View view) {

        lanzarActividadTipo();
    }

    public void onClickSiguiente(View view){

        lanzarActividadResumen();
    }

    public void lanzarActividadResumen(){

        Intent intent = new Intent(this, activity_4_resumen.class);

        intent.putExtra("informacionUsuario", informacionUsuario);
        intent.putStringArrayListExtra("listaPedido", listaPedido);
        intent.putExtra("arrayBebidas", arrayBebidas);


        startActivity(intent);
        finish();
    }

    public void lanzarActividadTipo(){

        Intent intent = new Intent(this, activity_2_tipo.class);
        intent.putExtra("informacionUsuario", informacionUsuario);
        intent.putStringArrayListExtra("listaPedido", listaPedido);
        intent.putExtra("arrayBebidas", arrayBebidas);

        startActivity(intent);
        finish();

    }

    public void onClickCarrito(View view){

        if(listaPedido.isEmpty()){
            Toast toastCarrito = Toast.makeText(getApplicationContext(),
                    "¡No hay nada que mostrar!", Toast.LENGTH_SHORT);
            toastCarrito.show();
        }else{
            Intent intent = new Intent(this, activity_carrito.class);
            intent.putStringArrayListExtra("listaPedido", listaPedido);
            startActivity(intent);
        }



    }

    public void rellenarArrayBebidas(){
        arrayBebidas[0] = tCantidadCocaCola.getText().toString();
        arrayBebidas[1] = tCantidadKasLimon.getText().toString();
        arrayBebidas[2] = tCantidadKasNaranja.getText().toString();
        arrayBebidas[3] = tCantidadNestea.getText().toString();
        arrayBebidas[4] = tCantidadCerveza.getText().toString();
        arrayBebidas[5] = tCantidadAgua.getText().toString();
    }

    public void reiniciarCantidades(){
        tCantidadCocaCola.setText("0");
        tCantidadKasLimon.setText("0");
        tCantidadKasNaranja.setText("0");
        tCantidadNestea.setText("0");
        tCantidadCerveza.setText("0");
        tCantidadAgua.setText("0");
    }

    public void corregirCeros(){
        if(tCantidadCocaCola.length()==0) {
            tCantidadCocaCola.setText("0");
        }
        if(tCantidadKasLimon.length()==0) {
            tCantidadKasLimon.setText("0");
        }
        if(tCantidadKasNaranja.length()==0) {
            tCantidadKasNaranja.setText("0");
        }
        if(tCantidadNestea.length()==0) {
            tCantidadNestea.setText("0");
        }
        if(tCantidadCerveza.length()==0) {
            tCantidadCerveza.setText("0");
        }
        if(tCantidadAgua.length()==0){
            tCantidadAgua.setText("0");
        }

    }

    public boolean sumarArrayBebidas(){
        int suma = 0;
        for(int i = 0; i < arrayBebidas.length; i++){
            suma = suma + Integer.parseInt(arrayBebidas[i]);
        }
        if(suma == 0){
            return false;
        }else{
            return true;
        }
    }
    public void onClickAnadir(View view){
        corregirCeros();
        rellenarArrayBebidas();

        if(sumarArrayBebidas()){
            reiniciarCantidades();

            Toast toastBebidasExito = Toast.makeText(getApplicationContext(),
                    "¡Bebidas añadidas correctamente!", Toast.LENGTH_SHORT);
            toastBebidasExito.show();
        }else{
            Toast toastBebidas = Toast.makeText(getApplicationContext(),
                    "¡No has elegido nada!", Toast.LENGTH_SHORT);
            toastBebidas.show();
        }






    }


}
