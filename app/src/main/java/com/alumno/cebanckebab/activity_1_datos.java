package com.alumno.cebanckebab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_1_datos extends AppCompatActivity {
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

    }

    public void onClickSalir(View view) {
        finish();
    }

    public void onClickSiguiente(View view){
        String telefono = eTelefono.getText().toString();

        if(validarTelefono(telefono)){
            lanzarActividadTipo();
        }else{
            toastTelefono();
        }


    }

    public void lanzarActividadTipo(){
        String nombre = eNombre.getText().toString();
        String direccion = eDireccion.getText().toString();
        String telefono = eTelefono.getText().toString();

        String[] informacionUsuario = {nombre, direccion, telefono};

        Intent intent = new Intent(this, activity_2_tipo.class);
        intent.putExtra("informacionUsuario", informacionUsuario);

        startActivity(intent);
        finish();
    }

    public boolean validarTelefono(String t) {
        String telefono = t;

        if(telefono.length()==9 && telefono.matches("\\d*")){
            return true;
        }
        return false;

    }

    public void toastTelefono(){

        Toast toastEnterNumeric = Toast.makeText(getApplicationContext(),
                "9 caracteres, sólo números", Toast.LENGTH_SHORT);
        toastEnterNumeric.show();
    }

}
