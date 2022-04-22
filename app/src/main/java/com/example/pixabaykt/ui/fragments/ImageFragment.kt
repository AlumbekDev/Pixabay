package com.example.pixabaykt.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.pixabaykt.R
import com.example.pixabaykt.databinding.FragmentImageBinding
import com.example.pixabaykt.ui.adapter.PixabayAdapter
import com.example.pixabaykt.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ImageFragment : Fragment(R.layout.fragment_image) {
    private lateinit var binding: FragmentImageBinding
    private val viewModel: PixabayViewModel by viewModels()
    private lateinit var pixabayAdapter: PixabayAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        pixabayAdapter = PixabayAdapter(PixabayAdapter.OnClickListener {

        })
        viewModel.getImages("")
        viewModel.fetchImagesFromDB("")
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
                    viewModel.fetchImagesFromDB(p0.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun subscribeOnline() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.searchQuery.observe(viewLifecycleOwner) { result ->
                when (result) {
                    is Resource.Success -> {
                        binding.progressBar.isVisible = false
                        binding.imageRecycler.isVisible = true
                        if (result.data?.isEmpty()!!) {
                            Toast.makeText(requireContext(), "No Images", Toast.LENGTH_LONG).show()
                        } else {
                            val pix = result.data
                            pixabayAdapter.submitList(pix)
                            binding.imageRecycler.adapter = pixabayAdapter
                            Timber.d("${result.data}")
                        }
                    }
                    is Resource.Error -> {
                        binding.progressBar.isVisible = true

                    }
                    is Resource.Loading -> {
                        binding.progressBar.isVisible = true

                    }
                }
            }
        }
    }
}


