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
import com.example.matthewmaxwell_mapd711_assignment3.databinding.ActivityHamiltonMapBinding

class HamiltonMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityHamiltonMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHamiltonMapBinding.inflate(layoutInflater)
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
        // location 1, art gallery of hamilton
        map = googleMap
        val latitude = 43.25753
        val longitude = -79.87162
        val officeLatLng = LatLng(latitude, longitude)
        val zoomLevel = 10f             //zoom level
        //add marker to office location
        map.addMarker(MarkerOptions().position(officeLatLng)
            .title("Cruise Main Office")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        // main location in city
        val latitude1 = 43.348331
        val longitude1 = -79.774097
        val latLng1 = LatLng(latitude1, longitude1)
        map.addMarker(MarkerOptions().position(latLng1)
            .title("Cruise Main Office")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //location2, spencer jeorge wilderness
        val latitude2 = 43.28287
        val longitude2 = -79.97869
        val latLng2 = LatLng(latitude2, longitude2)
        map.addMarker(MarkerOptions().position(latLng2)
            .title("spencer jeorge wilderness")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //childrens museum
        val latitude3 = 43.24728
        val longitude3 = -79.81601
        val latLng3 = LatLng(latitude3, longitude3)
        map.addMarker(MarkerOptions().position(latLng3)
            .title("Childrens' museum")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //ireland house museum
        val latitude4 = 43.36782
        val longitude4 = -79.82691
        val latLng4 = LatLng(latitude1, longitude2)
        map.addMarker(MarkerOptions().position(latLng4)
            .title("Ireland House Museum")
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