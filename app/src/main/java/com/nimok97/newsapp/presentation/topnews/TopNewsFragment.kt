package com.nimok97.newsapp.presentation.topnews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.map
import com.nimok97.newsapp.R
import com.nimok97.newsapp.databinding.FragmentTopnewsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TopNewsFragment : Fragment() {
    private var _binding: FragmentTopnewsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val topNewsViewModel: TopNewsViewModel by viewModels()

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
        observeData()
    }

    private fun initView() {
       setRecyclerView()
    }

    private fun setRecyclerView() {

    }

    private fun observeData() {
        topNewsViewModel.topNewsPagingData.flowWithLifecycle(lifecycle).onEach {
           // adapter.submitData(it)
            Log.e("${this.javaClass.simpleName}", "success")
            it.map {
                Log.e("AppTest", "$it")
            }
        }.launchIn(lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}