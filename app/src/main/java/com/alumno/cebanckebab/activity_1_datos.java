package com.alumno.cebanckebab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_1_datos extends AppCompatActivity {

    private String[] informacionUsuario;
    private ArrayList<String> listaPedido;
    private String[] arrayBebidas;


    EditText eNombre;
    EditText eDireccion;
    EditText eTelefono;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cebanc_kebab_1_datos);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));

        eNombre = (EditText) findViewById(R.id.editNombre);
        eDireccion = (EditText) findViewById(R.id.editDireccion);
        eTelefono = (EditText) findViewById(R.id.editTelefono);

        informacionUsuario = new String[3];
        listaPedido = new ArrayList<String>();
        arrayBebidas = new String[6];
        rellenarArrayBebidasACero();


    }

    public void rellenarArrayBebidasACero(){
        for(int i = 0; i < arrayBebidas.length; i++){
            arrayBebidas[i] = "0";
        }
    }

    public void onClickSalir(View view) {

        lanzarActividadMain();
    }

    public void onClickSiguiente(View view){
        String nombre = eNombre.getText().toString();
        String direccion = eDireccion.getText().toString();
        String telefono = eTelefono.getText().toString();
        String mensajeValidacion = "";

        Boolean nombreCorrecto = validarNombre(nombre);
        Boolean direccionCorrecto = validarDireccion(direccion);
        Boolean telefonoCorrecto = validarTelefono(telefono);

        if(!nombreCorrecto){
            mensajeValidacion = mensajeValidacion + "*!El campo 'Nombre' no puede estar vacío!\n";
        }
        if(!direccionCorrecto){
            mensajeValidacion = mensajeValidacion + "*¡El campo 'Dirección' no puede estar vacío!\n";
        }
        if(!telefonoCorrecto){
            mensajeValidacion = mensajeValidacion + "*¡El campo 'Teléfono' debe contener 9 números!\n";
        }

        if(!nombreCorrecto || !direccionCorrecto || !telefonoCorrecto){
            alertaValidacion(mensajeValidacion);
        }else{
            lanzarActividadTipo();
        }


    }

    public void alertaValidacion(String mensajeVal){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Cebanc Kebab");
        dialogo1.setMessage(mensajeVal);
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });

        dialogo1.show();
    }

    public void lanzarActividadMain(){
        Intent intent = new Intent(this, CebancKebabMainActivity.class);
        startActivity(intent);
        finish();
    }

    public void lanzarActividadTipo(){
        String nombre = eNombre.getText().toString();
        String direccion = eDireccion.getText().toString();
        String telefono = eTelefono.getText().toString();

        informacionUsuario[0] = nombre;
        informacionUsuario[1] = direccion;
        informacionUsuario[2] = telefono;

        Intent intent = new Intent(this, activity_2_tipo.class);
        intent.putExtra("informacionUsuario", informacionUsuario);
        intent.putExtra("arrayBebidas", arrayBebidas);
        intent.putStringArrayListExtra("listaPedido", listaPedido);

        startActivity(intent);
        finish();
    }

    public boolean validarNombre(String n) {
        String nombre = n;

        if(nombre.length()!=0){
            return true;
        }
        return false;

    }

    public boolean validarDireccion(String d) {
        String direccion = d;

        if(direccion.length()!=0){
            return true;
        }
        return false;

    }

    public boolean validarTelefono(String t) {
        String telefono = t;

        if(telefono.length()==9 && telefono.matches("\\d*")){
            return true;
        }
        return false;

    }

    public void onClickAcercaDe(View view){
        Toast toastCarrito = Toast.makeText(getApplicationContext(),
                R.string.toastAcercaDe, Toast.LENGTH_SHORT);
        toastCarrito.show();
    }

}
