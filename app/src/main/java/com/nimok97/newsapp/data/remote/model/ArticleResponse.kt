package com.nimok97.newsapp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    @SerialName("author")
    val author: String = "no author",
    @SerialName("title")
    val title: String = "no title",
    @SerialName("description")
    val description: String = "no description",
    @SerialName("url")
    val url: String,
    @SerialName("urlToImage")
    val urlToImage: String,
    @SerialName("publishedAt")
    val publishedAt: String,
    @SerialName("content")
    val content: String = "no content",
)