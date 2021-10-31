package com.example.matthewmaxwell_mapd711_assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //runs when button is pressed on main screen
    fun click(v: View){
        if (v.id==R.id.tvToronto) {
            Toast.makeText(applicationContext, "toroonto's map now", Toast.LENGTH_SHORT).show()
        }
        else if (v.id==R.id.tvMississauga) {
            Toast.makeText(this, "mississauga's map now", Toast.LENGTH_SHORT).show()
        }
        else if (v.id==R.id.tvOakville) {
            Toast.makeText(this, "oakville's map now", Toast.LENGTH_SHORT).show()
        }
        else if (v.id==R.id.tvHamilton) {
            Toast.makeText(this, "hanilton's map now", Toast.LENGTH_SHORT).show()
        }
        else if (v.id==R.id.tvNewYork) {
            Toast.makeText(this, "new york's map now", Toast.LENGTH_SHORT).show()
        }
    }
}