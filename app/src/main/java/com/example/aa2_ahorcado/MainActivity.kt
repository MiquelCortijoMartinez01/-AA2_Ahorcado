package com.example.aa2_ahorcado

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var myToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(myToolbar)

        if(supportFragmentManager.findFragmentById(R.id.frame) == null){
            loadFragment(LevelSelectorFragment())
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

    override fun onCreateOptionsMenu(menu:Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            // Codigo
            R.id.dark_mode -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
                true
            }
            R.id.light_mode -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
                true
            }
            R.id.exit -> {
                finish()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}



