package au.edu.swin.sdmd.l06_detailedimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import au.edu.swin.sdmd.l06_detailedimages.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val station = Location("Glenferrie Station", "Ada May Plante",
            -37.82154f, 145.03647f)

        val vStation = findViewById<TextView>(R.id.station)
        vStation.setOnClickListener {
            //todo
        }
    }


}