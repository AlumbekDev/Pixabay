package com.example.pixabaykt.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pixabaykt.presentation.ui.models.PixabayUI

class PixabayComparator : DiffUtil.ItemCallback<PixabayUI>() {
    override fun areItemsTheSame(oldItem: PixabayUI, newItem: PixabayUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PixabayUI, newItem: PixabayUI): Boolean {
        return oldItem.id == newItem.id
    }
}