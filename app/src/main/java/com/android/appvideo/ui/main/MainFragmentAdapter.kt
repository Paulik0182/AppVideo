package com.android.appvideo.ui.main

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.appvideo.data.FilmRepository
import com.android.appvideo.databinding.FragmentListDetailBinding

class MainFragmentAdapter(private var itemClickListener: MainFragment.OnItemViewClickListener?) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {
    private var weatherData: List<FilmRepository> = listOf()
    private lateinit var binding: FragmentListDetailBinding


    fun setWeather(data: List<FilmRepository>) {
        weatherData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        binding = FragmentListDetailBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(weatherData[position])
    }

    override fun getItemCount() = weatherData.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(FilmRepository: FilmRepository) = with(binding) {
            Texttext = FilmRepository
            root.setOnClickListener { itemClickListener?.onItemViewClick(FilmRepository) }
        }
    }
}