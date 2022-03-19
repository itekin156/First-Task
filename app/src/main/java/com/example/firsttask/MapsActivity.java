package com.example.firsttask;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationProviderClient;

    private Spinner spnDummyData;
    private TextView txtRestClose ;
    private static final int Req_CODE = 101;
    private Double lat , lng;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        txtRestClose = findViewById(R.id.txtRestClose);
        txtRestClose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LatLng p = new LatLng(36.1811758, 37.1267939);
                mMap.addMarker(new MarkerOptions().position(new LatLng(36.1812456, 37.1268582)).title("مناقيشووو"));
                mMap.addMarker(new MarkerOptions().position(new LatLng(36.181769, 37.131926)).title("شيف سلطان"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(p));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 15));

            }
        });

        spnDummyData = findViewById(R.id.spnDummydata);

        spnDummyData.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String plaseName = String.valueOf(spnDummyData.getSelectedItem());
                if(plaseName.equals("Grand Kadri Hotel By Cristal Lebanon"))
                {
                    LatLng p = new LatLng(33.85148430277257, 35.895525763213946);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(33.85148430277257, 35.895525763213946)).title("Grand Kadri Hotel By Cristal Lebanon"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(p));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 15));
                }

                if(plaseName.equals("Germanos - Pastry"))
                {
                    LatLng p = new LatLng(33.85217073479985, 35.89477838111461);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(33.85217073479985, 35.89477838111461)).title("Germanos - Pastry"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(p));
                     mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 15));

                }
                if(plaseName.equals("Malak el Tawook"))
                {
                    LatLng p = new LatLng(33.85334017189446, 35.89438946093824);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(33.85334017189446, 35.89438946093824)).title("Malak el Tawook"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(p));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 15));
                }
                if(plaseName.equals("Z Burger House"))
                {
                    LatLng p = new LatLng(33.85454300475094, 35.894561122304474);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(33.85454300475094, 35.894561122304474)).title("Z Burger House"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(p));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 15));
                }
                if(plaseName.equals("Collège Oriental"))
                {
                    LatLng p = new LatLng(33.85129821373707, 35.89446263654391);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(33.85129821373707, 35.89446263654391)).title("Collège Oriental"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(p));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 15));
                }

                if(plaseName.equals("VERO MODA"))
                {
                    LatLng p = new LatLng(33.85048738635312, 35.89664059012788);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(33.85048738635312, 35.89664059012788)).title("VERO MODA").snippet("click to show more details"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(p));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 15));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {


            }
        });


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.getApplicationContext());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
       getCurrentLocation();
    }






    @Override
    public void onLocalVoiceInteractionStarted()
    {
        super.onLocalVoiceInteractionStarted();
    }

    private void getCurrentLocation()
    {

        //Permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            //not granted then ask for permissions
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Req_CODE);
            return;
        }
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(60000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setFastestInterval(5000);
        LocationCallback locationCallback = new LocationCallback()
        {
            @Override
            public void onLocationResult(LocationResult locationResult)
            {
                super.onLocationResult(locationResult);
               // Toast.makeText(getApplicationContext(), "Location result is  " + locationResult, Toast.LENGTH_LONG).show();
                if (locationResult == null)
                {
                   // Toast.makeText(getApplicationContext(), "Location result is null ", Toast.LENGTH_LONG).show();
                    return;
                }
                for (Location location : locationResult.getLocations())
                {
                    if (location != null)
                    {
                       // Toast.makeText(getApplicationContext(), "Location result is  " + locationResult.getLocations(), Toast.LENGTH_LONG).show();

                    }
                }
            }
        };


        fusedLocationProviderClient.requestLocationUpdates(locationRequest , locationCallback , null);
        Task<Location> task =fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>()
        {
            @Override
            public void onSuccess(Location location)
            {
                if(location != null)
                {
                    lat = location.getAltitude();
                    lng = location.getLongitude();
                    LatLng latLng = new LatLng(lat,lng);
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    mMap.addMarker(new MarkerOptions().position(latLng).title("current location"));
                   // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                }
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (Req_CODE)
        {
            case Req_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    getCurrentLocation();
                }

        }
    }


}