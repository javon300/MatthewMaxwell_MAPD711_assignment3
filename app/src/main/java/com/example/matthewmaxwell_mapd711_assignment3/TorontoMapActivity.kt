package com.example.matthewmaxwell_mapd711_assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.matthewmaxwell_mapd711_assignment3.databinding.ActivityTorontoMapBinding

class TorontoMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityTorontoMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTorontoMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        // Royal ontario museum
        map = googleMap
        val latitude = 43.67091
        val longitude = -79.39464
        val officeLatLng = LatLng(latitude, longitude)
        val zoomLevel = 10f             //zoom level
        //add marker to office location
        map.addMarker(MarkerOptions().position(officeLatLng)
            .title("Royal Ontarion Museum")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //high park
        val latitude1 = 43.64750
        val longitude1 = -79.46359
        val latLng1 = LatLng(latitude1, longitude1)
        map.addMarker(MarkerOptions().position(latLng1)
            .title("High Park")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //casa loma museum
        val latitude2 = 43.68088
        val longitude2 = -79.40923
        val latLng2 = LatLng(latitude2, longitude2)
        map.addMarker(MarkerOptions().position(latLng2)
            .title("Casa Loma Museum")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //the haunted walk of toronto
        val latitude3 = 43.65091
        val longitude3 = -79.36035
        val latLng3 = LatLng(latitude3, longitude3)
        map.addMarker(MarkerOptions().position(latLng3)
            .title("The Haunted Walk of Toronto")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //allen garden
        val latitude4 = 43.66300
        val longitude4 = -79.37509
        val latLng4 = LatLng(latitude1, longitude2)
        map.addMarker(MarkerOptions().position(latLng4)
            .title("Allen Gardens")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //possition camera in area of home/cruise using latlng and zoom level
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(officeLatLng, zoomLevel))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // Change the map type based on the user's selection.
        R.id.normal_map -> {
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_map -> {
            map.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_map -> {
            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_map -> {
            map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}