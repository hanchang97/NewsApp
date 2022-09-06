package com.nimok97.newsapp.presentation.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nimok97.newsapp.R
import com.nimok97.newsapp.databinding.FragmentCategoriesBinding
import com.nimok97.newsapp.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : Fragment() {
    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_categories,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTestButton()
    }

    private fun setTestButton() {
        binding.categoriesBtnGotoCategorynews.setOnClickListener {
            mainViewModel.moveCategoriesToCategoryNews()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}