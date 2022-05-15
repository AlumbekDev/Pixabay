package com.example.pixabaykt.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pixabaykt.R
import com.example.pixabaykt.databinding.ImageItemBinding
import com.example.pixabaykt.presentation.models.PixabayUI
import com.example.pixabaykt.utils.PixabayComparator

class PixabayAdapter() : ListAdapter<PixabayUI, PixabayAdapter.PixabayViewHolder>(
    PixabayComparator()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixabayViewHolder {
        return PixabayViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: PixabayViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class PixabayViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(pixabayUI: PixabayUI) {
            Glide.with(binding.itemImg)
                .load(pixabayUI.webformatURL)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(binding.itemImg)
            binding.itemName.text = pixabayUI.user

        }
    }
}
