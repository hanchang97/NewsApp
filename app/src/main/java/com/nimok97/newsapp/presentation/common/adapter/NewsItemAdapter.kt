package com.nimok97.newsapp.presentation.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nimok97.newsapp.databinding.ItemNewsBinding
import com.nimok97.newsapp.domain.model.NewsItem

class NewsItemAdapter(private val itemClick: (newsItem: NewsItem?) -> Unit) :
    PagingDataAdapter<NewsItem, NewsItemAdapter.NewsItemViewHolder>(diffUtil) {

    class NewsItemViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: NewsItem?, itemClick: (newsItem: NewsItem?) -> Unit) {
            binding.newsItem = newsItem
            binding.root.setOnClickListener {
                itemClick(newsItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val binding =
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return NewsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(getItem(position), itemClick)
        //getItem(position)?.let { holder.bind(it, itemClick) }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<NewsItem>() {
            override fun areItemsTheSame(
                oldItem: NewsItem,
                newItem: NewsItem
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: NewsItem,
                newItem: NewsItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}