package au.edu.swin.sdmd.l06_detailedimages_2023

import android.app.Activity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    var location: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // process the data passed in
        /**
         * version 2.0: pass Parcelizable object
         */
        location = intent.getParcelableExtra<Location>("location")

        location?.let {
            val vName = findViewById<TextView>(R.id.name)
            vName.text = it.name

            val vAuthor = findViewById<TextView>(R.id.author)
            vAuthor.text = it.author

            val vLongtitude = findViewById<TextView>(R.id.longitude)
            vLongtitude.text = it.longitude.toString()

            val vLatitude = findViewById<TextView>(R.id.latitude)
            vLatitude.text = it.latitude.toString()

            // version 3.0: set visited passed in from MainActivity
            val vVisited = findViewById<Switch>(R.id.visited)
            vVisited.isChecked = it.visited
        }
    }

    /**
     * Handle user click on "Back": inform MainActivity with result
     * @version 3.0
     */
    override fun onBackPressed() {
        // pass result back to Main Activity
        location?.visited = findViewById<Switch>(R.id.visited).isChecked
        val i = intent.apply {
            putExtra("visited", location)
        }
        setResult(Activity.RESULT_OK, i)

        // called last!
        super.onBackPressed()
    }
}