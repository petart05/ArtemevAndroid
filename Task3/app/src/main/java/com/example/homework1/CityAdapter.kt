package com.example.homework1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.homework1.databinding.ItemCityBinding

class CityAdapter(
    private val list: List<City>,
    private val glide: RequestManager,
    private val onClick: (City) -> Unit
): RecyclerView.Adapter<CityHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CityHolder = CityHolder(
                ItemCityBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false),
                glide = glide,
                onClick = onClick
            )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CityHolder, position: Int){
        holder.onBind(list[position])
    }

}