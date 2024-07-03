package com.example.homework1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework1.databinding.FragmentNotificationsBinding

class NotificationsFragment  : Fragment(R.layout.fragment_notifications) {

    private var binding: FragmentNotificationsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotificationsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}