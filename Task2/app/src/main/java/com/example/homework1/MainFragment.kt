package com.example.homework1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework1.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.run{
            button.setOnClickListener {
                val text = Text.text
                if (text != null) {
                    if (text.isNotEmpty()) {
                        val bundle = Bundle()
                        bundle.putString("ARG_TEXT", text.toString())
                        findNavController().navigate(R.id.action_mainFragment_to_writedFragment,
                            args = bundle)
                    } else {
                        binding?.mainContainer?.let { it1 -> Snackbar.make(it1, "Для отправки текста требуется заполнить поле!", Snackbar.LENGTH_LONG).show() }
                    }
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}