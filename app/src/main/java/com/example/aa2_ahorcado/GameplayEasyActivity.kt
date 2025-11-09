package com.example.aa2_ahorcado

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.EditText
import android.widget.TextView

class GameplayEasyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay_easy)

        val images:List<ImageView> = listOf(
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

        val letters:List<TextView> = listOf(
            findViewById<TextView>(R.id.textView4),
            findViewById<TextView>(R.id.textView5),
            findViewById<TextView>(R.id.textView6),
            findViewById<TextView>(R.id.textView7)
        )

        val button:View = findViewById<View>(R.id.button)

        button.setOnClickListener {
            val charInput:EditText = findViewById<EditText>(R.id.charInput)
            val userChar:String = charInput.text.toString().uppercase()

            var found:Boolean = false

            for (letterView in letters) {
                if (letterView.text.toString() == userChar && letterView.currentTextColor != getColor(
                        android.R.color.background_dark
                    )
                ) {
                    letterView.setTextColor(getColor(android.R.color.background_dark))
                    letterView.visibility = View.VISIBLE
                    found = true
                }
            }

            if (!found) {
                showNext(images)
            }

            checkWin(letters)

            charInput.text.clear()
        }
    }
    private fun showNext(images: List<ImageView>) {//linea proporcionada por chatGpt
        val index:Int = images.indexOfLast { it.visibility == View.VISIBLE }//linea proporcionada por chatGpt
        val next:Int = (index + 1) % images.size
        images[next].visibility = View.VISIBLE
        if (next >= images.size - 1) {
            playerLose()
            return
        }
    }
    private fun checkWin(letters: List<TextView>) {
        val allRevealed:Boolean = letters.all { it.visibility == View.VISIBLE }//linea hecha por chatgpt

        if (allRevealed) {
            val intent:Intent = Intent(this, WinActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun playerLose() {
        val intent:Intent = Intent(this, LoseActivity::class.java)
        startActivity(intent)
        finish()
    }
}