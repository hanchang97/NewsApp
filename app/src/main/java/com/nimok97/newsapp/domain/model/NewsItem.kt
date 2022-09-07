package com.nimok97.newsapp.domain.model

data class NewsItem(
    val author: String,
    val title: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
)