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

    private ArrayList<String> listaPedido;
    private String[] informacionUsuario;

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
        //int cantidadCocaCola = Integer.parseInt(tCantidadCocaCola.getText().toString());
        //int cantidadKasLimon = Integer.parseInt(tCantidadKasLimon.getText().toString());
        //int cantidadKasNaranja = Integer.parseInt(tCantidadKasNaranja.getText().toString());
        //int cantidadNestea = Integer.parseInt(tCantidadNestea.getText().toString());
        //int cantidadCerveza = Integer.parseInt(tCantidadCerveza.getText().toString());
        //int cantidadAgua = Integer.parseInt(tCantidadAgua.getText().toString());

        //int[] cantidadesBebidas = {cantidadCocaCola, cantidadKasLimon, cantidadKasNaranja,
         //                           cantidadNestea, cantidadCerveza, cantidadAgua};

        Intent intent = new Intent(this, activity_4_resumen.class);

        intent.putExtra("informacionUsuario", informacionUsuario);
        intent.putStringArrayListExtra("listaPedido", listaPedido);


        startActivity(intent);
        finish();
    }

    public void lanzarActividadTipo(){

        Intent intent = new Intent(this, activity_2_tipo.class);
        intent.putExtra("informacionUsuario", informacionUsuario);
        intent.putStringArrayListExtra("listaPedido", listaPedido);

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

    public int sumar(String c){
        int cantidad = Integer.parseInt(c);
        cantidad = cantidad + 1;
        return cantidad;
    }

    public int restar(String c){
        int cantidad = Integer.parseInt(c);
        if(analizar(cantidad)){
            cantidad = cantidad - 1;
        }
        return cantidad;
    }

    public boolean analizar(int c){
        int cantidad = c;
        if(cantidad <= 0){
            return false;
        }else{
            return true;
        }
    }

    public void onClickMasCocaCola(View view){
            String cantidadCadena = tCantidadCocaCola.getText().toString();
            tCantidadCocaCola.setText(Integer.toString(sumar(cantidadCadena)));
    }

    public void onClickMasKasLimon(View view){
        String cantidadCadena = tCantidadKasLimon.getText().toString();
        tCantidadKasLimon.setText(Integer.toString(sumar(cantidadCadena)));
    }

    public void onClickMasKasNaranja(View view){
        String cantidadCadena = tCantidadKasNaranja.getText().toString();
        tCantidadKasNaranja.setText(Integer.toString(sumar(cantidadCadena)));
    }

    public void onClickMasNestea(View view){
        String cantidadCadena = tCantidadNestea.getText().toString();
        tCantidadNestea.setText(Integer.toString(sumar(cantidadCadena)));
    }

    public void onClickMasCerveza(View view){
        String cantidadCadena = tCantidadCerveza.getText().toString();
        tCantidadCerveza.setText(Integer.toString(sumar(cantidadCadena)));
    }


    public void onClickMasAgua(View view){
        String cantidadCadena = tCantidadAgua.getText().toString();
        tCantidadAgua.setText(Integer.toString(sumar(cantidadCadena)));
    }



    public void onClickMenosCocaCola(View view){
        String cantidadCadena = tCantidadCocaCola.getText().toString();
        tCantidadCocaCola.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosKasLimon(View view){
        String cantidadCadena = tCantidadKasLimon.getText().toString();
        tCantidadKasLimon.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosKasNaranja(View view){
        String cantidadCadena = tCantidadKasNaranja.getText().toString();
        tCantidadKasNaranja.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosNestea(View view){
        String cantidadCadena = tCantidadNestea.getText().toString();
        tCantidadNestea.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosCerveza(View view){
        String cantidadCadena = tCantidadCerveza.getText().toString();
        tCantidadCerveza.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosAgua(View view){
        String cantidadCadena = tCantidadAgua.getText().toString();
        tCantidadAgua.setText(Integer.toString(restar(cantidadCadena)));
    }

}
