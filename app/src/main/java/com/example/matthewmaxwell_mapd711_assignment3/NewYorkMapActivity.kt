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
import com.example.matthewmaxwell_mapd711_assignment3.databinding.ActivityNeyYorkMapBinding

class NewYorkMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityNeyYorkMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNeyYorkMapBinding.inflate(layoutInflater)
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
        // location 1, central park
        map = googleMap
        val latitude = 40.785091
        val longitude = -73.968285
        val officeLatLng = LatLng(latitude, longitude)
        val zoomLevel = 10f             //zoom level
        //add marker to office location
        map.addMarker(MarkerOptions().position(officeLatLng)
            .title("Central Park")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //empire state building
        val latitude1 = 40.748817
        val longitude1 = -73.985428
        val latLng1 = LatLng(latitude1, longitude1)
        map.addMarker(MarkerOptions().position(latLng1)
            .title("empire state building")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //statue of liberty
        val latitude2 = 40.689247
        val longitude2 = -74.044502
        val latLng2 = LatLng(latitude2, longitude2)
        map.addMarker(MarkerOptions().position(latLng2)
            .title("Statue of liberty")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //times square
        val latitude3 = 40.758896
        val longitude3 = -73.9760
        val latLng3 = LatLng(latitude3, longitude3)
        map.addMarker(MarkerOptions().position(latLng3)
            .title("Times Square")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //Newyork aquarium
        val latitude4 = 40.5740
        val longitude4 = -73.9760
        val latLng4 = LatLng(latitude1, longitude2)
        map.addMarker(MarkerOptions().position(latLng4)
            .title("New York Aquarim")
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