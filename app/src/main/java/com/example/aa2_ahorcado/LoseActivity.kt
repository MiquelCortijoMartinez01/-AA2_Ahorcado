package com.example.aa2_ahorcado

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)

        val splashLayout: View = findViewById(R.id.lose_layout)

        // Listener: detecta cualquier toque en la pantalla
        splashLayout.setOnClickListener {
            val intent:Intent = Intent(this, LevelSelectorActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}