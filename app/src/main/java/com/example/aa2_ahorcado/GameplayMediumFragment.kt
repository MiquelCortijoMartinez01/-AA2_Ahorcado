package com.example.aa2_ahorcado

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class GameplayMediumFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gameplay_medium, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images:List<ImageView> = listOf(
            view.findViewById<ImageView>(R.id.logo1),
            view.findViewById<ImageView>(R.id.logo2),
            view.findViewById<ImageView>(R.id.logo3),
            view.findViewById<ImageView>(R.id.logo4),
            view.findViewById<ImageView>(R.id.logo5),
            view.findViewById<ImageView>(R.id.logo6),
            view.findViewById<ImageView>(R.id.logo7),
            view.findViewById<ImageView>(R.id.logo8),
            view.findViewById<ImageView>(R.id.logo9),
            view.findViewById<ImageView>(R.id.logo10),
            view.findViewById<ImageView>(R.id.logo11),
            view.findViewById<ImageView>(R.id.logo12),
            view.findViewById<ImageView>(R.id.logo),
        )

        val letters:List<TextView> = listOf(
            view.findViewById<TextView>(R.id.textView4),
            view.findViewById<TextView>(R.id.textView5),
            view.findViewById<TextView>(R.id.textView6),
            view.findViewById<TextView>(R.id.textView7),
            view.findViewById<TextView>(R.id.textView8),
            view.findViewById<TextView>(R.id.textView9)
        )

        val button:View = view.findViewById<View>(R.id.button)

        button.setOnClickListener {
            val charInput:EditText = view.findViewById<EditText>(R.id.charInput)
            val userChar:String = charInput.text.toString().uppercase()

            var found:Boolean = false

            for (letterView in letters) {
                val letterColor = ContextCompat.getColor(requireContext(), android.R.color.background_dark)
                if (letterView.text.toString() == userChar && letterView.currentTextColor != letterColor) {
                    letterView.setTextColor(letterColor)
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
    private fun showNext(images: List<ImageView>) {
        val index:Int = images.indexOfLast { it.visibility == View.VISIBLE }
        val next:Int = (index + 1) % images.size
        images[next].visibility = View.VISIBLE
        if (next >= images.size - 1) {
            playerLose()
            return
        }
    }
    private fun checkWin(letters: List<TextView>) {
        val allRevealed:Boolean = letters.all { it.visibility == View.VISIBLE }

        if (allRevealed) {
            parentFragmentManager.beginTransaction().replace(R.id.frame, WinFragment()).commit()
        }
    }
    private fun playerLose() {
        parentFragmentManager.beginTransaction().replace(R.id.frame, LoseFragment()).commit()

    }
}