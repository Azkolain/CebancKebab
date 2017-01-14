package com.alumno.cebanckebab;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    private String resumen = "";

    private TextView tResumen;

    private CheckBox cPeluche;
    private CheckBox cComida;

    private double precioPedido = 0;
    private double precioBebidas = 0;
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

        escribirResumenFinal();
        establecerRegalos();


    }

    public void escribirResumenFinal(){
        resumen = escribeCliente();

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

    public String escribeCliente(){
        String mensaje;
        mensaje = informacionUsuario[0] + "\n" + informacionUsuario[1]
                + "\n" + informacionUsuario[2] + "\n\n";
        return mensaje;
    }

    public void establecerRegalos(){
        if(precioTotal>33){
            cPeluche.setChecked(true);
            cComida.setChecked(true);
        }else{
            if(precioTotal>23){
                cPeluche.setChecked(true);
                cComida.setChecked(false);
            }else{
                cPeluche.setChecked(false);
                cComida.setChecked(false);
            }
        }
    }


    public void alertaPedidoRealizado(){

            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Cebanc Kebab");
            dialogo1.setMessage("¡Muchas gracias por tu compra, vuelve cuando quieras!");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("¡Hasta otra!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    finish();
                }
            });

            dialogo1.show();
    }
    public void alertaTerminar() {

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Cebanc Kebab");
        dialogo1.setMessage("¿Desea realizar el pedido?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                alertaPedidoRealizado();
            }
        });
        dialogo1.setNegativeButton("Aún no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();

    }
    public void onClickRegalo(View view){
        lanzarActividadRegalo();
    }

    public void onClickTerminar(View view){

        alertaTerminar();

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


    public String escribePedido(){
        String resumen="Pedido:\n\n";

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

    public int sumarArray(){
        int suma=0;
        for(int i = 0; i < arrayBebidas.length; i++){
            suma = suma + Integer.parseInt(arrayBebidas[i]);
        }
        return suma;
    }
}
