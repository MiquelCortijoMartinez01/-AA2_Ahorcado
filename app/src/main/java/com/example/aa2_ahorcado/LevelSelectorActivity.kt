package com.example.aa2_ahorcado

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LevelSelectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_selector)

        val buttonEasy:View = findViewById<View>(R.id.button3)
        val buttonMedium:View = findViewById<View>(R.id.button4)
        val buttonHard:View = findViewById<View>(R.id.button5)

        buttonEasy.setOnClickListener {
            val intent:Intent = Intent(this, GameplayEasyActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonMedium.setOnClickListener {
            val intent:Intent = Intent(this, GameplayMediumActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonHard.setOnClickListener {
            val intent:Intent = Intent(this, GameplayHardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}