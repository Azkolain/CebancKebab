package com.alumno.cebanckebab;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by adminportatil on 18/12/2016.
 */

public class activity_2_tipo extends AppCompatActivity{

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


    public void onClickAnadir(View view){

    }

    public void lanzarActividadBebidas(){

        Intent intent = new Intent(this, activity_3_bebidas.class);
        intent.putExtra("informacionUsuario", informacionUsuario);

        startActivity(intent);
        finish();
    }


}
