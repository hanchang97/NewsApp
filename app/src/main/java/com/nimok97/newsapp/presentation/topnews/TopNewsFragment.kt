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
import androidx.recyclerview.widget.LinearLayoutManager
import com.nimok97.newsapp.R
import com.nimok97.newsapp.databinding.FragmentTopnewsBinding
import com.nimok97.newsapp.presentation.common.adapter.NewsItemAdapter
import com.nimok97.newsapp.presentation.common.decorator.VerticalItemDecorator
import com.nimok97.newsapp.presentation.common.dpToPx
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TopNewsFragment : Fragment() {
    private var _binding: FragmentTopnewsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val topNewsViewModel: TopNewsViewModel by viewModels()
    private lateinit var newsItemAdapter: NewsItemAdapter

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
        //topNewsViewModel.getNewsList()
    }

    private fun setRecyclerView() {
        newsItemAdapter = NewsItemAdapter {
            // detail 로 이동 + newsItem Bundle로 전달
            it?.let {
                findNavController().navigate(R.id.action_topNewsFragment_to_detailNewsFragment)
            }
        }

        binding.topnewsRv.apply {
            adapter = newsItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(VerticalItemDecorator(dpToPx(requireContext(), 16).toInt()))
        }
    }

    private fun observeData() {
        topNewsViewModel.topNewsPagingData.flowWithLifecycle(lifecycle).onEach {
            Log.e("${this.javaClass.simpleName}", "success")
            Log.e("${this.javaClass.simpleName}", "result null? : ${it == null}")
            newsItemAdapter.submitData(it)
        }.launchIn(lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}