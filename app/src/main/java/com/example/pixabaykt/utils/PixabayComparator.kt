package com.example.pixabaykt.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pixabaykt.data.local.entity.Pixabay

class PixabayComparator: DiffUtil.ItemCallback<Pixabay>() {
    override fun areItemsTheSame(oldItem: Pixabay, newItem: Pixabay): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: Pixabay, newItem: Pixabay): Boolean {
        return oldItem.id == newItem.id
    }
}