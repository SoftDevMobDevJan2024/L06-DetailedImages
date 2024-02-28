package au.edu.swin.sdmd.l06_detailedimages_2023

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    var location: Location? = null

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
    }
}