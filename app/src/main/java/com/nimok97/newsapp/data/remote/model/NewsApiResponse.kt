package com.nimok97.newsapp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsApiResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults: Int,
    @SerialName("articles")
    val articles: List<Article>
)