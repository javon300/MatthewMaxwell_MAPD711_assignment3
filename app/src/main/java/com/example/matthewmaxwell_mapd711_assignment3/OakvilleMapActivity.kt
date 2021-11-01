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
import com.example.matthewmaxwell_mapd711_assignment3.databinding.ActivityOakvilleMapBinding

class OakvilleMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityOakvilleMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOakvilleMapBinding.inflate(layoutInflater)
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
        // lion's vally park
        map = googleMap
        val latitude = 43.4600
        val longitude = -79.7485
        val officeLatLng = LatLng(latitude, longitude)
        val zoomLevel = 10f             //zoom level
        //add marker to office location
        map.addMarker(MarkerOptions().position(officeLatLng)
            .title("Lion's Vally Park")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //brontae heritage park
        val latitude1 = 43.3959
        val longitude1 = -79.7046
        val latLng1 = LatLng(latitude1, longitude1)
        map.addMarker(MarkerOptions().position(latLng1)
            .title("Brontae Heritage Park")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //Oakville lighthouse
        val latitude2 = 43.4418
        val longitude2 = -79.6695
        val latLng2 = LatLng(latitude2, longitude2)
        map.addMarker(MarkerOptions().position(latLng2)
            .title("Oakville Lighthouse")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //Film CA cinemas
        val latitude3 = 43.4463
        val longitude3 = -79.6902
        val latLng3 = LatLng(latitude3, longitude3)
        map.addMarker(MarkerOptions().position(latLng3)
            .title("Film CA Cinemas")
            .snippet("phone:18008745674" + " address: 232 meadowvale rd, toronto" + " Cruzers cruises"))

        //Gairlach Gardens
        val latitude4 = 43.4612
        val longitude4 = -79.6484
        val latLng4 = LatLng(latitude1, longitude2)
        map.addMarker(MarkerOptions().position(latLng4)
            .title("Gairlach Gardens")
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