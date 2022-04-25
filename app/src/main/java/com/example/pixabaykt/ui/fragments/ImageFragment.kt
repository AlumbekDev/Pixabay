package com.example.pixabaykt.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.pixabaykt.R
import com.example.pixabaykt.base.BaseFragment
import com.example.pixabaykt.databinding.FragmentImageBinding
import com.example.pixabaykt.ui.adapter.PixabayAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ImageFragment :
    BaseFragment<FragmentImageBinding, PixabayViewModel>(R.layout.fragment_image) {
    override lateinit var binding: FragmentImageBinding
    override val viewModel: PixabayViewModel by viewModels()
    private lateinit var pixabayAdapter: PixabayAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        pixabayAdapter = PixabayAdapter(PixabayAdapter.OnClickListener {

        })
        viewModel.getImages("")
        searchQuery()
        subscribeOnline()
        return binding.root
    }

    private fun searchQuery() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    viewModel.getImages(p0)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun subscribeOnline() {
        viewModel.searchQuery.spectateUiState(error = {
            Timber.e(it)
        },
            success = {
                pixabayAdapter.submitList(it)
            })
    }
}