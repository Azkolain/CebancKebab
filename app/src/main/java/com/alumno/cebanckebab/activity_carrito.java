package com.alumno.cebanckebab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by adminportatil on 09/01/2017.
 */

public class activity_carrito extends AppCompatActivity {

    private double precioPedido = 0;
    private double precioBebidas = 0;
    private double precioTotal;

    private ArrayList<String> listaPedido;
    private TextView tResumen;
    private String resumen = "";
    private String[] arrayBebidas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        tResumen = (TextView) findViewById(R.id.textResumen);



        //--------------------------------------

        Bundle extras = getIntent().getExtras();
        listaPedido = getIntent().getStringArrayListExtra("listaPedido");
        arrayBebidas = extras.getStringArray("arrayBebidas");

        escribirResumenFinal();
    }

    public void escribirResumenFinal(){

        if(!listaPedido.isEmpty()){
            resumen = resumen + escribePedido();
        }

        if(sumarArray()==0){
            //no hacemos nada
        }else{
            resumen = resumen + escribeBebidas();
        }

        precioTotal = precioPedido + precioBebidas;

        resumen = resumen + "Precio total: " + Double.toString(precioTotal) + "€";

        tResumen.setText(resumen);
    }


    public String escribePedido(){
        String resumenPed="Pedido:\n\n";

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

            resumenPed = resumenPed + cantidad + " x " + nombreProducto + " " + tipoCarne + ", " + tipoTamaino + "\n"
                    + "(" + precio + "€ x " + cantidad + " = " + precioTotal + " €)\n\n";



        }

        return resumenPed;

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

    public String escribeBebidas(){
        String resumenBeb="Bebidas:\n\n";

        for(int i = 0; i < arrayBebidas.length; i ++){
            if(Integer.parseInt(arrayBebidas[i])>0){
                String nombreBebida = comprobarBebida(i);
                Double precioCadaBebida = comprobarPrecioBebida(i);
                int cantidad = Integer.parseInt(arrayBebidas[i]);
                Double precioTotalBebida = precioCadaBebida * cantidad;

                precioBebidas = precioBebidas + precioTotalBebida;

                resumenBeb = resumenBeb + Integer.toString(cantidad) + " x "+ nombreBebida + "\n("
                        +  Double.toString(precioCadaBebida) + " € x "
                        + Integer.toString(cantidad) + " = " + Double.toString(precioTotalBebida) + "€)\n\n";
            }
        }


        return resumenBeb;

    }

    public Double comprobarPrecioBebida(int indice){
        Double precio = 0.0;
        if(indice == 0){
            precio = 1.50;
        }else{
            if(indice == 1){
                precio = 1.50;
            }else{
                if(indice == 2){
                    precio = 1.50;
                }else{
                    if(indice == 3){
                        precio = 1.50;
                    }else{
                        if(indice == 4){
                            precio = 2.0;
                        }else{
                            if(indice == 5){
                                precio = 0.70;
                            }
                        }
                    }
                }
            }
        }
        return precio;
    }

    public String comprobarBebida(int indice){
        String nombreBebida = "";
        if(indice == 0){
            nombreBebida = "Coca Cola 33cl";
        }else{
            if(indice == 1){
                nombreBebida = "Fanta Limón 33cl";
            }else{
                if(indice == 2){
                    nombreBebida = "Fanta Naranja 33cl";
                }else{
                    if(indice == 3){
                        nombreBebida = "Nestea 33cl";
                    }else{
                        if(indice == 4){
                            nombreBebida = "Heineken 33cl";
                        }else{
                            if(indice == 5){
                                nombreBebida = "Agua 50cl";
                            }
                        }
                    }
                }
            }
        }
        return nombreBebida;
    }

    public int sumarArray(){
        int suma=0;
        for(int i = 0; i < arrayBebidas.length; i++){
            suma = suma + Integer.parseInt(arrayBebidas[i]);
        }
        return suma;
    }
}
