package com.dicoding.picodiploma.myfinalsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacters: RecyclerView
    private val list = ArrayList<Character>()

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            title = getString(R.string.home_string)
        }

        rvCharacters = findViewById(R.id.rv_character)
        rvCharacters.setHasFixedSize(true)

        list.addAll(getListCharacters())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
            R.id.action_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND);
                shareIntent.type = "text/plain";
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Please reach me at ntmygaa@gmail.com");
                startActivity(Intent.createChooser(shareIntent, "Share Link"))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCharacters(): ArrayList<Character> {
        val names = resources.getStringArray(R.array.names)
        val descriptions = resources.getStringArray(R.array.descriptions)
        val details = resources.getStringArray(R.array.details)
        val voices = resources.getStringArray(R.array.voices)
        val photos = resources.obtainTypedArray(R.array.photos)
        val listCharacter = ArrayList<Character>()

        for (i in names.indices) {
            val character = Character(names[i], descriptions[i], photos.getResourceId(i, -1), details[i], voices[i])
            listCharacter.add(character)
        }

        return listCharacter
    }

    private fun showRecyclerList() {
        rvCharacters.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = ListCharacterAdapter(list)
        rvCharacters.adapter = listCharacterAdapter
    }

}