package com.alumno.cebanckebab;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_2_tipo extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cebanc_kebab_2_tipo);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));



    }

    public void onClickSalir(View view) {
        finish();
    }

    public void onClickSiguiente(View view){
        lanzarActividadBebidas();
    }

    public void lanzarActividadBebidas(){
        Intent intent = new Intent(this, activity_3_bebidas.class);
        startActivity(intent);
        finish();
    }

}
