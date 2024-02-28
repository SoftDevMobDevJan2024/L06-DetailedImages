package au.edu.swin.sdmd.l06_detailedimages

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // process the data passed in
        /*version 1.0: pass primitive values */
        val vName = findViewById<TextView>(R.id.name)
        val name = intent.getStringExtra("name")
        vName.text = name

        val vAuthor = findViewById<TextView>(R.id.author)
        val author = intent.getStringExtra("author")
        vAuthor.text = author

        val vLongtitude = findViewById<TextView>(R.id.longitude)
        val longitude = intent.getFloatExtra("longitude", 0f)
        vLongtitude.text = when (longitude) {
            0f -> ""
            else -> longitude.toString()
        }

        val vLatitude = findViewById<TextView>(R.id.latitude)
        val latitude = intent.getFloatExtra("latitude", 0f)
        vLatitude.text = when (latitude) {
            0f -> ""
            else -> latitude.toString()
        }
    }
}