package com.example.homework1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.homework1.databinding.FragmentCitiesBinding

class CitiesFragment  : Fragment(R.layout.fragment_cities) {

    private var binding: FragmentCitiesBinding? = null
    private var adapter: CityAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCitiesBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    private fun initAdapter(){

        binding?.run {
            adapter = CityAdapter(
                CityRepository.cities,
                Glide.with(this@CitiesFragment),
                onClick = {
                    val id = it.id
                    val bundle = Bundle()
                    bundle.putString("ARG_TEXT", id.toString())
                    findNavController().navigate(R.id.action_citiesFragment_to_cityFragment, bundle)


                }
            )

            rvCity.adapter = adapter
            rvCity.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
}