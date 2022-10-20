package com.nimok97.newsapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.nimok97.newsapp.R
import com.nimok97.newsapp.databinding.FragmentDetailnewsBinding
import com.nimok97.newsapp.presentation.common.printLog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailNewsFragment : Fragment() {
    private var _binding: FragmentDetailnewsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val args by navArgs<DetailNewsFragmentArgs>() // TopNewsFragment 에서 데이터 전달 받기 위함

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_detailnews,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printLog(args.newsItem.toString())
        initView()
    }

    private fun initView() {
        setAppBar()
    }

    private fun setAppBar() {
        binding.detailnewsMtb.setNavigationOnClickListener {
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