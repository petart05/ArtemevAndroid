package com.example.homework1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework1.databinding.FragmentSettingsBinding

class SettingsFragment  : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}