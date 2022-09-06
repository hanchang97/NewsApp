package com.nimok97.newsapp.presentation.topnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nimok97.newsapp.R
import com.nimok97.newsapp.databinding.FragmentTopnewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopNewsFragment : Fragment() {
    private var _binding: FragmentTopnewsBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_topnews,
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
        setTestBtn()
    }

    private fun setTestBtn() {
        binding.topnewsBtnGotoDetailnews.setOnClickListener {
            findNavController().navigate(R.id.action_topNewsFragment_to_detailNewsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}