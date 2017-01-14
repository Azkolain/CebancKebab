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

        if(listaPedido.isEmpty() && sumarArray() == 0){
            Toast toastPedidoVacio = Toast.makeText(getApplicationContext(),
                    R.string.toastPedidoVacio, Toast.LENGTH_SHORT);
            toastPedidoVacio.show();
        }else{
            lanzarActividadResumen();
        }


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

        if(listaPedido.isEmpty() && sumarArray() == 0){
            Toast toastCarrito = Toast.makeText(getApplicationContext(),
                    R.string.toastCarrito, Toast.LENGTH_SHORT);
            toastCarrito.show();
        }else{
            Intent intent = new Intent(this, activity_carrito.class);
            intent.putStringArrayListExtra("listaPedido", listaPedido);
            intent.putExtra("arrayBebidas", arrayBebidas);
            startActivity(intent);
        }



    }

    public void rellenarArrayBebidas(){
        arrayBebidas[0] = Integer.toString(Integer.parseInt(arrayBebidas[0]) + Integer.parseInt(tCantidadCocaCola.getText().toString()));
        arrayBebidas[1] = Integer.toString(Integer.parseInt(arrayBebidas[1]) + Integer.parseInt(tCantidadKasLimon.getText().toString()));
        arrayBebidas[2] = Integer.toString(Integer.parseInt(arrayBebidas[2]) + Integer.parseInt(tCantidadKasNaranja.getText().toString()));
        arrayBebidas[3] = Integer.toString(Integer.parseInt(arrayBebidas[3]) + Integer.parseInt(tCantidadNestea.getText().toString()));
        arrayBebidas[4] = Integer.toString(Integer.parseInt(arrayBebidas[4]) + Integer.parseInt(tCantidadCerveza.getText().toString()));
        arrayBebidas[5] = Integer.toString(Integer.parseInt(arrayBebidas[5]) + Integer.parseInt(tCantidadAgua.getText().toString()));
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
        int[] sumaArray = new int[6];
        int suma = 0;
        sumaArray[0] = Integer.parseInt(tCantidadCocaCola.getText().toString());
        sumaArray[1] = Integer.parseInt(tCantidadKasLimon.getText().toString());
        sumaArray[2] = Integer.parseInt(tCantidadKasNaranja.getText().toString());
        sumaArray[3] = Integer.parseInt(tCantidadNestea.getText().toString());
        sumaArray[4] = Integer.parseInt(tCantidadCerveza.getText().toString());
        sumaArray[5] = Integer.parseInt(tCantidadAgua.getText().toString());

        for (int i = 0; i < sumaArray.length; i++){
            suma = suma + sumaArray[i];
        }
        if(suma == 0){
            return false;
        }else{
            return true;
        }
    }

    public int sumarArray(){
        int suma=0;
        for(int i = 0; i < arrayBebidas.length; i++){
            suma = suma + Integer.parseInt(arrayBebidas[i]);
        }
        return suma;
    }
    public void onClickAnadir(View view){
        corregirCeros();
        rellenarArrayBebidas();

        if(sumarArrayBebidas()){
            reiniciarCantidades();

            Toast toastBebidasExito = Toast.makeText(getApplicationContext(),
                    R.string.toastBebidasAnadidas, Toast.LENGTH_SHORT);
            toastBebidasExito.show();
        }else{
            Toast toastBebidas = Toast.makeText(getApplicationContext(),
                    R.string.toastPedidoVacio, Toast.LENGTH_SHORT);
            toastBebidas.show();
        }
    }

}
