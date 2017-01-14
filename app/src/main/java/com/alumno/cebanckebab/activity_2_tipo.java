package com.alumno.cebanckebab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_2_tipo extends AppCompatActivity{

    private String[] informacionUsuario;
    private ArrayList<String> listaPedido;
    private String[] arrayBebidas;

    private ViewFlipper TruitonFlipper;
    private float initialX;

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
        listaPedido = getIntent().getStringArrayListExtra("listaPedido");
        arrayBebidas = extras.getStringArray("arrayBebidas");

        TruitonFlipper = (ViewFlipper) findViewById(R.id.flipper);
        TruitonFlipper.setInAnimation(this, android.R.anim.fade_in);
        TruitonFlipper.setOutAnimation(this, android.R.anim.fade_out);

        sTamaino = (Spinner) findViewById(R.id.spinnerTamaino);
        sTipo = (Spinner) findViewById(R.id.spinnerTipo);
        tCantidadProducto = (TextView) findViewById(R.id.editCantidadProducto);



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

    public void corregirCeros() {
        if (tCantidadProducto.length() == 0) {
            tCantidadProducto.setText("0");
        }
    }
    public void onClickAnadir(View view){
        corregirCeros();
        if(tCantidadProducto.getText().toString().equals("0")){
            Toast toastCantidad = Toast.makeText(getApplicationContext(),
                            R.string.toastPedidoVacio, Toast.LENGTH_SHORT);
            toastCantidad.show();
        }else{
            anadirProducto();
        }
    }
    public void anadirProducto(){
        String lineaPedido;

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

        lineaPedido = Integer.toString(selectedProducto) + ";" + Integer.toString(selectedTipo) + ";"
                + Integer.toString(selectedTamaino) + ";" + Integer.toString(cantidadInt) + ";"
                + Double.toString(precioDouble) + ";" + Double.toString(precioTotalDouble);

        pedidoSimilar(lineaPedido);

        reiniciarCantidad();

        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Se añadió:\n" + cantidad + " x " + nombreProducto + " " + tipoCarne + ", " + tipoTamaino
                                + " (" + precioTotal + "€) ", Toast.LENGTH_SHORT);

        toast1.show();
    }


    public void reiniciarCantidad(){
        tCantidadProducto.setText("0");
    }

    public void pedidoSimilar(String p){
        boolean continuar = true;
        String[] lineaPendiente = p.split(";");
        String pendiente = lineaPendiente[0]+lineaPendiente[1]+lineaPendiente[2];
        for(int i = 0; i < listaPedido.size() && continuar; i++){

            String linea;
            linea = listaPedido.get(i);

            String[] lineaExistente = linea.split(";");
            String existente = lineaExistente[0]+lineaExistente[1]+lineaExistente[2];

            if(pendiente.equals(existente)){
                int cantidadPendiente = Integer.parseInt(lineaPendiente[3]);
                int cantidadExistente = Integer.parseInt(lineaExistente[3]);
                int nuevaCantidad = cantidadPendiente + cantidadExistente;
                double precioExistente = Double.parseDouble(lineaExistente[4]);
                double nuevoPrecioTotal = nuevaCantidad * precioExistente;

                String lineaPedidoNueva;
                lineaPedidoNueva = lineaExistente[0] + ";" + lineaExistente[1] + ";" + lineaExistente[2] + ";"
                        + Integer.toString(nuevaCantidad) + ";" + lineaExistente[4] + ";" + Double.toString(nuevoPrecioTotal);
                listaPedido.set(i,lineaPedidoNueva);

                continuar = false;

            }

        }

        if(continuar == true){
            listaPedido.add(p);
        }
    }

    public void lanzarActividadBebidas(){

        Intent intent = new Intent(this, activity_3_bebidas.class);
        intent.putExtra("informacionUsuario", informacionUsuario);
        intent.putStringArrayListExtra("listaPedido", listaPedido);
        intent.putExtra("arrayBebidas", arrayBebidas);

        startActivity(intent);
        finish();
    }

    public void lanzarActividadDatos(){
        Intent intent = new Intent(this, activity_1_datos.class);
        startActivity(intent);
        finish();
    }

    public int sumarArray(){
        int suma=0;
        for(int i = 0; i < arrayBebidas.length; i++){
            suma = suma + Integer.parseInt(arrayBebidas[i]);
        }
        return suma;
    }

    public void onClickCarrito(View view){

        if(listaPedido.isEmpty() && sumarArray()==0){
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

    public void onClickSalir(View view) {

        alertaSalir();

    }

    public void onClickSiguiente(View view){

        lanzarActividadBebidas();
    }

    public void alertaSalir() {

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Cebanc Kebab");
        dialogo1.setMessage("¿Seguro que quieres volver atrás? ¡Perderás tu pedido!");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Atrás", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                lanzarActividadDatos();
            }
        });
        dialogo1.setNegativeButton("Continuar con la compra", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();

    }





}
