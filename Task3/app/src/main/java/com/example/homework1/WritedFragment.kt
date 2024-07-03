package com.example.homework1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework1.databinding.FragmentWritedBinding

class WritedFragment: Fragment(R.layout.fragment_writed) {

    private var binding: FragmentWritedBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWritedBinding.bind(view)
        val text = arguments?.getString("ARG_TEXT")?:"ERROR"
        binding?.run{
            textView2.text = text
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}