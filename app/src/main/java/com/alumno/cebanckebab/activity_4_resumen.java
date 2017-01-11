package com.alumno.cebanckebab;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_4_resumen extends AppCompatActivity{
    private ArrayList<String> listaPedido;
    private String[] informacionUsuario;
    private String[] arrayBebidas;
    private String resumen;

    private TextView tResumen;

    private CheckBox cPeluche;
    private CheckBox cComida;

    private double precioPedido = 0;
    private double precioBebida = 0;
    private double precioTotal;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cebanc_kebab_4_resumen);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));

        Bundle extras = getIntent().getExtras();
        informacionUsuario = extras.getStringArray("informacionUsuario");
        listaPedido = getIntent().getStringArrayListExtra("listaPedido");
        arrayBebidas = extras.getStringArray("arrayBebidas");

        tResumen = (TextView) findViewById(R.id.textResumen);

        cPeluche = (CheckBox) findViewById(R.id.checkPeluche);
        cComida = (CheckBox) findViewById(R.id.checkComida);
        cPeluche.setChecked(false);
        cComida.setChecked(false);

        resumen = escribeResumen();
        tResumen.setText(resumen);

        establecerRegalos();


    }

    public void establecerRegalos(){
        if(precioPedido>33){
            cPeluche.setChecked(true);
            cComida.setChecked(true);
        }else{
            if(precioPedido>23){
                cPeluche.setChecked(true);
                cComida.setChecked(false);
            }else{
                cPeluche.setChecked(false);
                cComida.setChecked(false);
            }
        }
    }

    public void onClickRegalo(View view){
        lanzarActividadRegalo();
    }

    public void onClickSalir(View view) {

        lanzarActividadBebidas();
    }

    public void lanzarActividadRegalo(){
        Intent intent = new Intent(this, activity_regalo.class);
        startActivity(intent);
    }

    public void lanzarActividadBebidas(){
        Intent intent = new Intent(this, activity_3_bebidas.class);

        intent.putExtra("informacionUsuario", informacionUsuario);
        intent.putExtra("arrayBebidas", arrayBebidas);
        intent.putStringArrayListExtra("listaPedido", listaPedido);

        startActivity(intent);
        finish();
    }



    public String escribeResumen(){
        String resumen="";

        for(int i=0;i<listaPedido.size();i++){
            String linea;
            linea = listaPedido.get(i);

            String[] lineaElementos = linea.split(";");

            String nombreProducto = lineaElementos[0];
            nombreProducto = establecerProducto(Integer.parseInt(nombreProducto));

            String tipoCarne = lineaElementos[1];
            tipoCarne = establecerCarne(Integer.parseInt(tipoCarne));

            String tipoTamaino = lineaElementos[2];
            tipoTamaino = establecerTamaino(Integer.parseInt(tipoTamaino));

            String cantidad = lineaElementos[3];
            String precio = lineaElementos[4];
            String precioTotal = lineaElementos[5];

            precioPedido = precioPedido + Double.parseDouble(precioTotal);

            resumen = resumen + cantidad + " x " + nombreProducto + " " + tipoCarne + ", " + tipoTamaino + "\n"
                    + "(" + precio + "€ x " + cantidad + " = " + precioTotal + " €)\n\n";



        }

        resumen = resumen + "Precio total: " + precioPedido + "€";

        Log.e("loco", resumen);
        return resumen;

    }

    public String establecerProducto(int p){
        String producto;
        if(p == 0){
            producto = "Döner";
        }else{
            if(p == 1){
                producto = "Dürum";
            }else{
                if(p == 2){
                    producto = "Lahmacum";
                }else{
                    if(p == 3){
                        producto = "Hamburguesa";
                    }else{
                        producto = "Pedrata";
                    }
                }
            }
        }
        return producto;
    }

    public String establecerCarne(int c){
        String tipoCarne;
        if(c == 0){
            tipoCarne = "de ternera";
        }else{
            if(c == 1){
                tipoCarne = "de pollo";
            }else{
                tipoCarne = "de carne mixta";
            }
        }
        return tipoCarne;
    }

    public String establecerTamaino(int t){
        String tipoTamaino;
        if(t == 0){
            tipoTamaino = "completo";
        }else{
            tipoTamaino = "sólo carne";
        }
        return tipoTamaino;
    }
}
