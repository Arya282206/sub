package com.dicoding.picodiploma.myfinalsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailCharacterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)

        supportActionBar?.apply {
            title = getString(R.string.detail_string)
        }

        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val name = findViewById<TextView>(R.id.tv_item_name)
        val description = findViewById<TextView>(R.id.tv_item_description)
        val detail = findViewById<TextView>(R.id.tv_item_detail)
        val voice = findViewById<TextView>(R.id.tv_item_voice)

        val intentData = intent
        photo.setImageResource(intentData.getIntExtra("photo", 0))
        name.text = intentData.getStringExtra("name")
        description.text = intentData.getStringExtra("description")
        detail.text = intentData.getStringExtra("detail")
        voice.text = intentData.getStringExtra("voice")
    }
}