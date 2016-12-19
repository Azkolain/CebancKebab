package com.alumno.cebanckebab;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_3_bebidas extends AppCompatActivity{
    private String[] informacionUsuario;
    private String[] cantidadesKebab;

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
        cantidadesKebab = extras.getStringArray("cantidadesKebab");

        tCantidadCocaCola = (TextView) findViewById(R.id.textCantidadCocaCola);
        tCantidadKasLimon = (TextView) findViewById(R.id.textCantidadKasLimon);
        tCantidadKasNaranja = (TextView) findViewById(R.id.textCantidadKasNaranja);
        tCantidadNestea = (TextView) findViewById(R.id.textCantidadNestea);
        tCantidadCerveza = (TextView) findViewById(R.id.textCantidadCerveza);
        tCantidadAgua = (TextView) findViewById(R.id.textCantidadAgua);
    }

    public void onClickSalir(View view) {
        finish();
    }

    public void onClickSiguiente(View view){
        lanzarActividadResumen();
    }

    public void lanzarActividadResumen(){
        Intent intent = new Intent(this, activity_4_resumen.class);
        startActivity(intent);
        finish();
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
