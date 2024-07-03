package com.example.homework1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.homework1.databinding.FragmentCityBinding
import com.example.homework1.databinding.FragmentMainBinding
import com.example.homework1.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar

class CityFragment : Fragment(R.layout.fragment_city) {

    private var binding: FragmentCityBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCityBinding.bind(view)
        val id = arguments?.getString("ARG_TEXT")?:"ERROR"
        binding?.run{

            tvCity.text = CityRepository.cities[Integer.parseInt(id)].name
            tvCountry.text = CityRepository.cities[Integer.parseInt(id)].country
            tvDescription.text = CityRepository.cities[Integer.parseInt(id)].description
            val url = CityRepository.cities[Integer.parseInt(id)].url

            Glide.with(view).load(url).into(ivCity)

            ivButtonBack.setOnClickListener {
                findNavController().navigate(R.id.action_cityFragment_to_citiesFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}