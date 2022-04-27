package com.example.pixabaykt.presentation.ui.fragments

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pixabaykt.R
import com.example.pixabaykt.base.BaseFragment
import com.example.pixabaykt.databinding.FragmentImageBinding
import com.example.pixabaykt.presentation.ui.adapter.PixabayAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PixabayFragment :
    BaseFragment<FragmentImageBinding, PixabayViewModel>(R.layout.fragment_image) {
    override val binding: FragmentImageBinding by viewBinding(FragmentImageBinding::bind)
    override val viewModel: PixabayViewModel by viewModels()
    private val pixabayAdapter = PixabayAdapter()

    override fun initialize() {
        binding.imageRecycler.adapter = pixabayAdapter
    }

    override fun establishRequest() {
        viewModel.getImages("")
        searchQuery()
    }

    override fun launchObservers() {
        subscribeOnline()
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
        viewModel.searchQuery.spectateUiState(
            error = {
                Timber.e(it)
            },
            success = {
                pixabayAdapter.submitList(it.hits)
            })
    }
}