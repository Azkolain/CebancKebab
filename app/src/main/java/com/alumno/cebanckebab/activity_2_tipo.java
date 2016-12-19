package com.alumno.cebanckebab;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_2_tipo extends AppCompatActivity{
    private String[] informacionUsuario;

    private TextView tCantidadDoner;
    private TextView tCantidadDurum;
    private TextView tCantidadLahmacum;
    private TextView tCantidadShawarma;
    private TextView tCantidadGyros;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cebanc_kebab_2_tipo);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));

        Bundle extras = getIntent().getExtras();
        informacionUsuario = extras.getStringArray("informacionUsuario");

        tCantidadDoner = (TextView) findViewById(R.id.textCantidadDoner);
        tCantidadDurum = (TextView) findViewById(R.id.textCantidadDurum);
        tCantidadLahmacum = (TextView) findViewById(R.id.textCantidadLahmacum);
        tCantidadShawarma = (TextView) findViewById(R.id.textCantidadShawarma);
        tCantidadGyros = (TextView) findViewById(R.id.textCantidadGyros);

    }

    public void onClickSalir(View view) {
        finish();
    }

    public void onClickSiguiente(View view){

        lanzarActividadBebidas();
    }

    public void lanzarActividadBebidas(){
        int cantidadDoner = Integer.parseInt(tCantidadDoner.getText().toString());
        int cantidadDurum = Integer.parseInt(tCantidadDurum.getText().toString());
        int cantidadLahmacum = Integer.parseInt(tCantidadLahmacum.getText().toString());
        int cantidadShawarma = Integer.parseInt(tCantidadShawarma.getText().toString());
        int cantidadGyros = Integer.parseInt(tCantidadGyros.getText().toString());

        int[] cantidadesKebab = {cantidadDoner, cantidadDurum, cantidadLahmacum, cantidadShawarma, cantidadGyros};


        Intent intent = new Intent(this, activity_3_bebidas.class);
        intent.putExtra("informacionUsuario", informacionUsuario);
        intent.putExtra("cantidadesKebab", cantidadesKebab);

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

    public void onClickMasDoner(View view){
        String cantidadCadena = tCantidadDoner.getText().toString();
        tCantidadDoner.setText(Integer.toString(sumar(cantidadCadena)));
    }

    public void onClickMasDurum(View view){
        String cantidadCadena = tCantidadDurum.getText().toString();
        tCantidadDurum.setText(Integer.toString(sumar(cantidadCadena)));
    }

    public void onClickMasLahmacum(View view){
        String cantidadCadena = tCantidadLahmacum.getText().toString();
        tCantidadLahmacum.setText(Integer.toString(sumar(cantidadCadena)));
    }

    public void onClickMasShawarma(View view){
        String cantidadCadena = tCantidadShawarma.getText().toString();
        tCantidadShawarma.setText(Integer.toString(sumar(cantidadCadena)));
    }

    public void onClickMasGyros(View view){
        String cantidadCadena = tCantidadGyros.getText().toString();
        tCantidadGyros.setText(Integer.toString(sumar(cantidadCadena)));
    }


    public void onClickMenosDoner(View view){
        String cantidadCadena = tCantidadDoner.getText().toString();
        tCantidadDoner.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosDurum(View view){
        String cantidadCadena = tCantidadDurum.getText().toString();
        tCantidadDurum.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosLahmacum(View view){
        String cantidadCadena = tCantidadLahmacum.getText().toString();
        tCantidadLahmacum.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosShawarma(View view){
        String cantidadCadena = tCantidadShawarma.getText().toString();
        tCantidadShawarma.setText(Integer.toString(restar(cantidadCadena)));
    }

    public void onClickMenosGyros(View view){
        String cantidadCadena = tCantidadGyros.getText().toString();
        tCantidadGyros.setText(Integer.toString(restar(cantidadCadena)));
    }




}
