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
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class CebancKebabMainActivity extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap mapa;
    private FirstMapFragment mFirstMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cebanc_kebab_main);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#088A08")));

        mFirstMapFragment = FirstMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map, mFirstMapFragment)
                .commit();

        // Registrar escucha onMapReadyCallback
        mFirstMapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(36.2048, 138.2529);

        MarkerOptions markerOptions =
                new MarkerOptions()
                        .position(latLng)
                        .title("Japón")
                        .snippet("Primer ministro: Shinzō Abe");

        Marker marker = googleMap.addMarker(markerOptions);
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


