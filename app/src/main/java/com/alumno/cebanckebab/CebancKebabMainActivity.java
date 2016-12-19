package com.alumno.cebanckebab;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class CebancKebabMainActivity extends AppCompatActivity {
    private GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cebanc_kebab_main);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));





    }

    public void onClickSalir(View view) {
        finish();
    }

    public void onClickSiguiente(View view){
        lanzarActividadDatos();
    }

    public void lanzarActividadDatos(){
        Intent intent = new Intent(this, activity_1_datos.class);
        startActivity(intent);
        finish();
    }

}


