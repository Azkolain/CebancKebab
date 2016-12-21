package com.alumno.cebanckebab;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_4_resumen extends AppCompatActivity{
    private String[] informacionUsuario;
    private String[] cantidadesKebab;
    private boolean tamainoCompleta;
    private String tipoCarne;
    private String[] cantidadesBebidas;

    private TextView tResumen;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cebanc_kebab_4_resumen);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));

        Bundle extras = getIntent().getExtras();
        informacionUsuario = extras.getStringArray("informacionUsuario");
        cantidadesKebab = extras.getStringArray("cantidadesKebab");
        cantidadesBebidas = extras.getStringArray("cantidadesBebidas");
        tamainoCompleta = extras.getBoolean("tamainoCompleta");
        tipoCarne = extras.getString("tipoCarne");

        tResumen = (TextView) findViewById(R.id.textResumen);

    }

    public void crearResumen(){
        String resumen;
        resumen = tipoCarne;
        if(tamainoCompleta){
            tResumen.setText("egie");
        }

    }
}
