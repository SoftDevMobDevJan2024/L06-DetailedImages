package au.edu.swin.sdmd.l06_detailedimages_2023

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var station: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        station = Location("Glenferrie Station", "Ada May Plante",
            -37.821539f, 145.036473f)

        val vStation = findViewById<TextView>(R.id.station)
        vStation.setOnClickListener {
            // todo: create Intent
            val intent = Intent(this, DetailActivity::class.java);

            // pass data to the target activity
            intent.apply {
                putExtra("name", station.name)
                putExtra("author", station.author)
                putExtra("longitude", station.longitude)
                putExtra("latitude", station.latitude)
            }

            // show the detail-activity view
            // version 1.0-2.0 : start activity without expecting a result
            startActivity(intent)
        }
    }

}