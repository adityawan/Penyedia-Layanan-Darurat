package com.example.windyseptaa.penyedialayanandarurat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener

{

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location lastLocation;
    private Marker currentUserLocationMarker;
    private static final int Request_User_Location_Code = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            checkUserLocationPermission();
        }
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling

            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }

        // Polisi
        LatLng polisi1 = new LatLng(-0.515381, 117.115857);
        mMap.addMarker(new MarkerOptions()
                .position(polisi1)
                .title("Polresta Samarinda")
                .snippet("Jl. Slamet Riyadi No.1, Karang Asam Ulu, Sungai Kunjang, Kota Samarinda, Kalimantan Timur")

                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polisi1));

        LatLng polisi2 = new LatLng(-0.458140, 117.189017);
        mMap.addMarker(new MarkerOptions()
                .position(polisi2)
                .title("Polsekta Samarinda Utara")
                .snippet("Jl. D.I. Panjaitan, Mugirejo, Samarinda, Mugirejo, Kec. Sungai Pinang, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polisi2));

        LatLng polisi3 = new LatLng(-0.489736, 117.143730);
        mMap.addMarker(new MarkerOptions()
                .position(polisi3)
                .title("Polsekta Samarinda Ilir")
                .snippet("Jl. Bhayangkara No.3, Bugis, Samarinda Kota, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polisi3));

        LatLng polisi4 = new LatLng(-0.478063, 117.131370);
        mMap.addMarker(new MarkerOptions()
                .position(polisi4)
                .title("Polsekta Samarinda Ulu")
                .snippet("Jl. Juanda 110, Sidodadi, Samarinda Ulu, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polisi4));

        LatLng polisi5 = new LatLng(-0.513270, 117.092231);
        mMap.addMarker(new MarkerOptions()
                .position(polisi5)
                .title("Polsekta Sungai Kunjang")
                .snippet("Jl. Jakarta, Loa Bakung, Sungai Kunjang, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polisi5));

        LatLng polisi6 = new LatLng(-0.513669, 117.144045);
        mMap.addMarker(new MarkerOptions()
                .position(polisi6)
                .title("Polsekta Samarinda Seberang")
                .snippet("Jl. Sulta Hasanuddin, Baqa, Samarinda Seberang, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polisi6));


        // Rumah Sakit
        LatLng rumahsakit1 = new LatLng(-0.478713, 117.144270);
        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(rumahsakit1)
                .title("RSUD AW Sjahranie")
                .snippet("Jl. Palang Merah No.1, Sidodadi, Samarinda Ulu, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit1));

        LatLng rumahsakit2 = new LatLng(-0.471680, 117.124447);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit2)
                .title("RS Samarinda Medika Citra")
                .snippet("Jl. Kadrie Oening No.86 RT. 35, Air Putih, Samarinda Ulu, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit2));

        LatLng rumahsakit3 = new LatLng(-0.558590, 117.110377);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit3)
                .title("RSUD Inche Abdoel Moeis")
                .snippet("Jl. H.A.M. Rifaddin No.1, Harapan Baru, Kec. Loa Janan Ilir, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit3));

        LatLng rumahsakit4 = new LatLng(-0.472902, 117.142559);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit4)
                .title("RS Bersalin Ria Kencana")
                .snippet("Jl. Letnan Jend. Suprapto No.1, Gn. Kelua, Samarinda Ulu, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit4));

        LatLng rumahsakit5 = new LatLng(-0.501132, 117.155054);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit5)
                .title("RS Ibu & Anak H. Thaha Bakrie")
                .snippet("Jl. Pangeran Hidayatullah No. 11, RT. 39, Samarinda Hilir, Pelabuhan, Samarinda Kota, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit5));

        LatLng rumahsakit6 = new LatLng(-0.501399, 117.154585);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit6)
                .title("RS Ibu & Anak Aisyiah Samarinda")
                .snippet("Jl. Pangeran Hidayatullah No.64, Pelabuhan, Samarinda Kota, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit6));

        LatLng rumahsakit7 = new LatLng(-0.473751, 117.142466);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit7)
                .title("RS Siaga Ramania")
                .snippet("Jl. Ramania No.3, Sidodadi, Samarinda Ulu, Sidodadi, Samarinda Ulu, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit7));

        LatLng rumahsakit8 = new LatLng(-0.498600, 117.137142);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit8)
                .title("RS Dirgahayu")
                .snippet("Jl. Gunung Merbabu No.62, Samarinda Ulu, Jawa, Samarinda Ulu, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit8));

        LatLng rumahsakit9 = new LatLng(-0.506400, 117.159762);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit9)
                .title("RS Islam Samarinda")
                .snippet("Jl. Gurami No.18, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit9));

        LatLng rumahsakit10 = new LatLng(-0.495424, 117.147167);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit10)
                .title("RS Bhakti Nugraha")
                .snippet("Jl. Basuki Rahmat No.50, Bugis, Samarinda Kota, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit10));

        LatLng rumahsakit11 = new LatLng(-0.494499, 117.148807);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit11)
                .title("RS Haji Darjad")
                .snippet("Jl. Dahlia No.4, Bugis, Samarinda Kota, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit11));

        LatLng rumahsakit12 = new LatLng(-0.461809, 117.183697);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit12)
                .title("RS Ibu & Anak Qurratun Ayun")
                .snippet("Jl. DI Panjaitan No.77, Mugirejo, Kec. Sungai Pinang, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit12));

        LatLng rumahsakit13 = new LatLng(-0.500943, 117.143097);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit13)
                .title("RS Tentara Kesdim Samarinda")
                .snippet("Jl. Jend. Sudirman No.20, Bugis, Samarinda Kota, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit13));

        LatLng rumahsakit14 = new LatLng(-0.505735, 117.159541);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit14)
                .title("RS Jiwa Daerah Atma Husada Mahakam")
                .snippet("Jl. Kakap, Sungai Dama, Samarinda Ilir, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit14));

//            LatLng rumahsakit15 = new LatLng(-0.475164, 117.161802);
//            mMap.addMarker(new MarkerOptions().position(rumahsakit15).title("Klinik Utama Bunda Kasih Cendrawasih").snippet("Jl. Ahmad Yani No.23, Sungai Pinang Dalam, Kec. Sungai Pinang, Kota Samarinda, Kalimantan Timur "));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit15));

        LatLng rumahsakit16 = new LatLng(-0.521861, 117.116279);
        mMap.addMarker(new MarkerOptions()
                .position(rumahsakit16)
                .title("RS Ibu dan Anak Herawaty")
                .snippet("Jl. Untung Surapati No 2, Karang Asam Ulu, Sungai Kunjang, Kota Samarinda, Kalimantan Timur ")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahsakit16));

        // Pemadam Kebakaran
        LatLng damkar1 = new LatLng(-0.575920, 117.086003);
        mMap.addMarker(new MarkerOptions()
                .position(damkar1)
                .title("Posko IX Damkar Kota Samarinda")
                .snippet("Simpang Tiga, Kec. Loa Janan Ilir, Kota Samarinda, Kalimantan Timur 75391")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(damkar1));

        LatLng damkar2 = new LatLng(-0.497442, 117.155976);
        mMap.addMarker(new MarkerOptions()
                .position(damkar2)
                .title("Dharma Wanita Persatuan Kantor Pemadam Kebakaran Kota Samarinda")
                .snippet("Jl. Mulawarman No.14, Karang Mumus, Samarinda Kota, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(damkar2));

        LatLng damkar3 = new LatLng(-0.500874, 117.140183);
        mMap.addMarker(new MarkerOptions()
                .position(damkar3)
                .title("Posko V Damkar Kota Samarinda")
                .snippet("Jl. Sultan Hasanuddin, Baqa, Samarinda Seberang, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(damkar3));

        LatLng damkar4 = new LatLng(-0.514227, 117.091523);
        mMap.addMarker(new MarkerOptions()
                .position(damkar4)
                .title("Posko X Damkar Kota Samarinda")
                .snippet("Loa Bakung, Sungai Kunjang, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(damkar4));

        LatLng damkar5 = new LatLng(-0.483958, 117.122578);
        mMap.addMarker(new MarkerOptions()
                .position(damkar5)
                .title("Posko III Damkar Kota Samarinda")
                .snippet("Air Putih, Samarinda Ulu, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(damkar5));

        LatLng damkar6 = new LatLng(-0.453919, 117.114509);
        mMap.addMarker(new MarkerOptions()
                .position(damkar6)
                .title("Posko XI Damkar Kota Samarinda")
                .snippet("Bukit Pinang, Samarinda Ulu, Kota Samarinda, Kalimantan Timur")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(damkar6));

    }

    public boolean checkUserLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_User_Location_Code);
            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_User_Location_Code);
            }
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case Request_User_Location_Code:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        if(googleApiClient == null)
                        {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(this, "Permission Denied...", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    protected synchronized void buildGoogleApiClient(){
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        googleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        lastLocation = location;

        if(currentUserLocationMarker != null)
        {
            currentUserLocationMarker.remove();
        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Lokasi Saya");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        currentUserLocationMarker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(11));

        if(googleApiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, (com.google.android.gms.location.LocationListener) this);
        }
    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(11000);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, (com.google.android.gms.location.LocationListener) this);
        }



    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

}
