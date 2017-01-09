package com.alumno.cebanckebab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_2_tipo extends AppCompatActivity{

    private ArrayList<String> listaPedido;

    private ViewFlipper TruitonFlipper;
    private float initialX;

    private String[] informacionUsuario;
    private String[][] pedidoProductos = new String[6][5];

    private Spinner sTamaino;
    private Spinner sTipo;
    private TextView tCantidadProducto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cebanc_kebab_2_tipo);

        //--------------------------------------

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));

        Bundle extras = getIntent().getExtras();
        informacionUsuario = extras.getStringArray("informacionUsuario");

        TruitonFlipper = (ViewFlipper) findViewById(R.id.flipper);
        TruitonFlipper.setInAnimation(this, android.R.anim.fade_in);
        TruitonFlipper.setOutAnimation(this, android.R.anim.fade_out);

        sTamaino = (Spinner) findViewById(R.id.spinnerTamaino);
        sTipo = (Spinner) findViewById(R.id.spinnerTipo);
        tCantidadProducto = (TextView) findViewById(R.id.editCantidadProducto);

        listaPedido = new ArrayList<String>();

    }

    @Override
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float finalX = touchevent.getX();
                if (initialX > finalX) {
                    //if (TruitonFlipper.getDisplayedChild() == 1)
                    //break;

                    TruitonFlipper.setInAnimation(this, R.anim.in_right);
                    TruitonFlipper.setOutAnimation(this, R.anim.out_left);

                    TruitonFlipper.showNext();
                } else {
                    if (initialX < finalX) {
                        //if (TruitonFlipper.getDisplayedChild() == 0)
                        //break;

                        TruitonFlipper.setInAnimation(this, R.anim.in_left);
                        TruitonFlipper.setOutAnimation(this, R.anim.out_right);

                        TruitonFlipper.showPrevious();
                    }
                }
                break;
        }
        return false;
    }

    public void onClickSalir(View view) {

        finish();
    }

    public void onClickSiguiente(View view){

        lanzarActividadBebidas();
    }

    public double establecerPrecio(int p, int c, int t){
        double precio;
        if(p == 0){
            precio = 3.50;
        }else{
            if(p == 1){
                precio = 4.50;
            }else{
                if(p == 2){
                    precio = 5;
                }else{
                    if(p == 3){
                        precio = 3;
                    }else{
                        precio = 5.50;
                    }
                }
            }
        }

        if(c == 2){
            precio = precio + 0.50;
        }

        if(t == 1){
            precio = precio + 1;
        }
        return precio;
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

    public void onClickAnadir(View view){
        if(tCantidadProducto.getText().toString().equals("0") || tCantidadProducto.getText().toString().equals("")){
            Toast toastCantidad = Toast.makeText(getApplicationContext(),
                            "¡Debes introducir una cantidad!", Toast.LENGTH_SHORT);
            toastCantidad.show();
        }else{
            anadirProducto();
        }
    }
    public void anadirProducto(){


        int selectedProducto = TruitonFlipper.getDisplayedChild();
        int selectedTipo = sTipo.getSelectedItemPosition();
        int selectedTamaino = sTamaino.getSelectedItemPosition();
        int cantidadInt = Integer.parseInt(tCantidadProducto.getText().toString());
        double precioDouble = establecerPrecio(selectedProducto, selectedTipo, selectedTamaino);
        double precioTotalDouble = precioDouble * cantidadInt;



        String nombreProducto = establecerProducto(selectedProducto);
        String tipoCarne = establecerCarne(selectedTipo);
        String tipoTamaino = establecerTamaino(selectedTamaino);
        String cantidad = Integer.toString(cantidadInt);
        String precio = Double.toString(precioDouble);
        String precioTotal = Double.toString(precioTotalDouble);

        listaPedido.add(nombreProducto + ";" + tipoCarne + ";" + tipoTamaino + ";"
                + precio + ";" + cantidad + ";" + precioTotal);
        Log.d("loko", listaPedido.get(0));

        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Se añadió:\n" + cantidad + " x " + nombreProducto + " " + tipoCarne + ", " + tipoTamaino
                                + " (" + precioTotal + "€) ", Toast.LENGTH_SHORT);

        toast1.show();
    }

    public void lanzarActividadBebidas(){

        Intent intent = new Intent(this, activity_3_bebidas.class);
        intent.putExtra("informacionUsuario", informacionUsuario);

        startActivity(intent);
        finish();
    }

    public void onClickCarrito(View view){
        String resumenCompra;
        Intent intent = new Intent(this, activity_carrito.class);
        intent.putStringArrayListExtra("listaPedido", listaPedido);
        startActivity(intent);


    }




}
