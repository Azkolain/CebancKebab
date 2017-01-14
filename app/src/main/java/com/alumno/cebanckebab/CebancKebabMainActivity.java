package com.alumno.cebanckebab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
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

        alertaSalir();

    }

    public void onClickSiguiente(View view) {
        lanzarActividadDatos();
    }

    public void onClickLlamar(View view) {
        llamarContacto();
    }

    public void alertaSalir() {

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Cebanc Kebab");
        dialogo1.setMessage("¿Seguro que quieres cerrar la aplicación?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                finish();
            }
        });
        dialogo1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();

    }

    public void lanzarActividadDatos() {
        Intent intent = new Intent(this, activity_1_datos.class);
        startActivity(intent);
        finish();
    }

    public void llamarContacto() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:943316900"));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    public void onClickAcercaDe(View view){
        Toast toastCarrito = Toast.makeText(getApplicationContext(),
                R.string.toastAcercaDe, Toast.LENGTH_SHORT);
        toastCarrito.show();
    }
}




