package com.example.aa2_ahorcado

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class LevelSelectorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_level_selector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonEasy:View = view.findViewById<View>(R.id.button3)
        val buttonMedium:View = view.findViewById<View>(R.id.button4)
        val buttonHard:View = view.findViewById<View>(R.id.button5)

        buttonEasy.setOnClickListener {
            //requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frame, GameplayEasyFragment()).commit()
        }
        buttonMedium.setOnClickListener {
            //requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frame, GameplayMediumFragment()).commit()
        }
        buttonHard.setOnClickListener {
            //requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frame, GameplayHardFragment()).commit()
        }
    }
}