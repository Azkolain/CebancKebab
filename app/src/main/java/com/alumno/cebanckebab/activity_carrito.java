package com.alumno.cebanckebab;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adminportatil on 09/01/2017.
 */

public class activity_carrito extends AppCompatActivity {

    private double precioPedido = 0;

    private ArrayList<String> listaPedido;
    private TextView tResumen;
    private String resumen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        tResumen = (TextView) findViewById(R.id.textResumen);

        Log.e("llegamos","lokosss");


        //--------------------------------------

        Bundle extras = getIntent().getExtras();
        listaPedido = getIntent().getStringArrayListExtra("listaPedido");

        Log.e("loko", listaPedido.get(0));

        resumen = escribeResumen();

        tResumen.setText(resumen);
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
