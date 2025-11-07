package com.example.aa2_ahorcado

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.EditText
import android.widget.TextView

class GameplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        val gameplayLayout: View = findViewById(R.id.gameplay_layout)

        val charInput = findViewById<EditText>(R.id.charInput)
        val userChar = charInput.text.toString()
        val textView = findViewById<TextView>(R.id.textView3)
        textView.text = userChar

        val images = listOf(
            findViewById<ImageView>(R.id.logo1),
            findViewById<ImageView>(R.id.logo2),
            findViewById<ImageView>(R.id.logo3),
            findViewById<ImageView>(R.id.logo4),
            findViewById<ImageView>(R.id.logo5),
            findViewById<ImageView>(R.id.logo6),
            findViewById<ImageView>(R.id.logo7),
            findViewById<ImageView>(R.id.logo8),
            findViewById<ImageView>(R.id.logo9),
            findViewById<ImageView>(R.id.logo10),
            findViewById<ImageView>(R.id.logo11),
            findViewById<ImageView>(R.id.logo12),
            findViewById<ImageView>(R.id.logo),
        )

        //Listener: detecta cualquier toque en la pantalla
        gameplayLayout.setOnClickListener {
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
            //finish()
            showNext(images)
            //val topImage = findViewById<ImageView>(R.id.logo1)
            //topImage.visibility = View.GONE
        }
    }
    private fun showNext(images: List<ImageView>) {
        val index = images.indexOfLast { it.visibility == View.VISIBLE }
        val next = (index + 1) % images.size
        images[next].visibility = View.VISIBLE
        val charInput = findViewById<EditText>(R.id.charInput)
        val userChar = charInput.text.toString()
        val textView = findViewById<TextView>(R.id.textView3)
        textView.text = userChar
    }


}