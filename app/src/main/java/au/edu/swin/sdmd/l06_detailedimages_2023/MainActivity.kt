package au.edu.swin.sdmd.l06_detailedimages_2023

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
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

            /* version 2.0: pass Parcelizable object */
            intent.apply {
                putExtra("location", station)
            }

            // show the detail-activity view
            // version 1.0-2.0 : start activity without expecting a result
            // startActivity(intent)

            // version 3.0: start activity expecting a result
            startForResult.launch(intent)
        }
    }

    // version 3.0: start activity expecting a result
    // pass data back from the child activity
    val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        // Handle the returned result
        // Log.i("RESULT", "returned ${result.data.toString()}")
        when(result.resultCode) {
            RESULT_OK -> {
                val data = result.data
                val visited = data?.getParcelableExtra<Location>("visited")
                val vStation = findViewById<TextView>(R.id.station)
                visited?.let{
                    vStation.setTextColor(if (it.visited) Color.GREEN else Color.RED)
                    station = visited
                }
            }
        }
    }
}