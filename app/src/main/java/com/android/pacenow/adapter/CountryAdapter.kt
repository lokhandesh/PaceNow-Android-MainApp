package com.android.pacenow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.pacenow.databinding.AdapterCountryBinding
import com.android.pacenow.model.CountryData

class CountryAdapter(private var list : List<CountryData.Country>) : RecyclerView.Adapter<CountryAdapter.DataViewHolder>() {


    inner class DataViewHolder(private val binding: AdapterCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: CountryData.Country) {
            binding.txtTitle.text = get.full_name_english
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder = DataViewHolder(AdapterCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(list.get(position))

    override fun getItemCount(): Int = list.size

    fun setItem(list: List<CountryData.Country>) {
        this.list = list
        notifyDataSetChanged()
    }

}