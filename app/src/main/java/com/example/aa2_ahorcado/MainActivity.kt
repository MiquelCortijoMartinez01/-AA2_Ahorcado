package com.example.aa2_ahorcado

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.activity.ComponentActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var myToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(myToolbar)
    }

    override fun onCreateOptionsMenu(menu:Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(item.itemId == R.id.dark_mode) {
            // Codigo
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            delegate.applyDayNight()
            true
        } else if (item.itemId == R.id.light_mode) {
            // Codigo
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            delegate.applyDayNight()
            true
        } else if (item.itemId == R.id.exit) {
            finish()
            true
        }else {
            super.onOptionsItemSelected(item)
        }
    }
}