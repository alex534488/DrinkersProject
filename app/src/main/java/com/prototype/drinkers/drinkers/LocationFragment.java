package com.prototype.drinkers.drinkers;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by alex on 2017-03-12.
 */

public class LocationFragment extends Fragment implements
        OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowCloseListener{

    private GoogleMap mMap;
    static final LatLng BAR_POS_FLIRT = new LatLng(48.426540, -71.066500);
    static final LatLng BAR_POS_START = new LatLng(48.426540, -71.066500);
    static final String BAR_NAME_FLIRT = "Bar Le Flirt";
    private Button mapConfirmButton;
    private Button mapCancelButton;
    private String currentId;
    private OnMapCancel cancelCallback;
    private OnMapConfirm confirmCallback;

    View myView;
    MapView mMapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.location_layout,container, false);

        mMapView = (MapView) myView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(this);

        return myView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Get buttons
        mapConfirmButton = (Button)myView.findViewById(R.id.map_confirm);
        mapCancelButton = (Button)myView.findViewById(R.id.map_cancel);

        //Cancel/Confirm listeners
        mapConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentId != ""){
                    if(confirmCallback != null)
                        confirmCallback.onMapConfirm(currentId);
                }
            }
        });
        mapCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cancelCallback != null)
                    cancelCallback.onMapCancel();
            }
        });

        mapConfirmButton.setEnabled(false);

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(BAR_POS_FLIRT).title(BAR_NAME_FLIRT));

        //Zoom in
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BAR_POS_START));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        //Listener
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowCloseListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        currentId = marker.getTitle();
        mapConfirmButton.setEnabled(true);


        Toast.makeText(getContext(),
                currentId + " has been clicked.",
                Toast.LENGTH_SHORT).show();

        return false;
    }

    @Override
    public void onInfoWindowClose(Marker marker) {

        currentId = "";
        mapConfirmButton.setEnabled(false);

        Toast.makeText(getContext(),
                marker.getTitle() + " has been closed.",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
