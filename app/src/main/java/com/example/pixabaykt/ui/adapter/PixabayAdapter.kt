package com.example.pixabaykt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pixabaykt.data.local.entity.Pixabay
import com.example.pixabaykt.utils.PixabayComparator
import com.example.pixabaykt.R
import com.example.pixabaykt.databinding.ImageItemBinding

class PixabayAdapter(): ListAdapter<Pixabay, PixabayAdapter.PixabayViewHolder>(
    PixabayComparator()
) {

    inner class PixabayViewHolder(private val binding: ImageItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pixabay: Pixabay) {
            Glide.with(binding.imageView)
                .load(pixabay.webformatURL)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(binding.imageView)
            binding.user.text = pixabay.user
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixabayViewHolder {
        val imageItemBinding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PixabayViewHolder(imageItemBinding)
    }

    override fun onBindViewHolder(holder: PixabayViewHolder, position: Int) {
        val pixabay = getItem(position)
        holder.bind(pixabay)
    }
}
