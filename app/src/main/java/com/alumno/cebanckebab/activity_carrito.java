package com.alumno.cebanckebab;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by adminportatil on 09/01/2017.
 */

public class activity_carrito extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        //--------------------------------------

        Bundle extras = getIntent().getExtras();
        ArrayList<String> listaPedido = getIntent().getStringArrayListExtra("listaPedido");

        Log.e("loko", listaPedido.get(0));
    }
}
