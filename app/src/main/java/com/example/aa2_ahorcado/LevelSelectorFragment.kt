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

        val buttons = listOf(
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button10,
            R.id.button11,
        )

        val fragments = listOf(
            GameplayEasyFragment(),
            GameplayMediumFragment(),
            GameplayHardFragment(),
            GameplayEasyFragment(),
            GameplayMediumFragment(),
            GameplayHardFragment(),
            GameplayEasyFragment(),
            GameplayMediumFragment(),
            GameplayHardFragment(),
        )

        buttons.forEachIndexed { index, id -> val button = view.findViewById<View>(id)
            button.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frame, fragments[index]).commit()
            }
        }
    }
}