package com.nimok97.newsapp.presentation.categories.categoryNews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nimok97.newsapp.R
import com.nimok97.newsapp.databinding.FragmentCategorynewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryNewsFragment : Fragment() {
    private var _binding: FragmentCategorynewsBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_categorynews,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        setAppBar()
    }

    private fun setAppBar() {
        binding.categorynewsMtb.setNavigationOnClickListener {
            activity?.let {
                it.onBackPressed()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}