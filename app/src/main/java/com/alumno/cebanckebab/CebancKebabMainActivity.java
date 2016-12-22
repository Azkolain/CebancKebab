package com.alumno.cebanckebab;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class CebancKebabMainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mapa;
    private FirstMapFragment mFirstMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cebanc_kebab_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#088A08")));

        mFirstMapFragment = FirstMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map, mFirstMapFragment)
                .commit();

        // Registrar escucha onMapReadyCallback
        mFirstMapFragment.getMapAsync(this);

    }

    public void onMapReady(GoogleMap googleMap) {
        LatLng cebanckebab = new LatLng(43.30469411639206, -2.0168709754943848);

        googleMap.addMarker(new MarkerOptions()
                .position(cebanckebab)
                .title("Cebanc-Kebab")
                .snippet("Berio Pasealekua, San Sebastian"))
                .showInfoWindow();
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(cebanckebab)
                .zoom(13)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


    }

    public void onClickSalir(View view) {
        finish();
    }

    public void onClickSiguiente(View view) {
        lanzarActividadDatos();
    }

    public void onClickLlamar(View view) {
        llamarContacto();
    }

    public void lanzarActividadDatos() {
        Intent intent = new Intent(this, activity_1_datos.class);
        startActivity(intent);
        finish();
    }

    public void llamarContacto() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:649606224"));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }
}




