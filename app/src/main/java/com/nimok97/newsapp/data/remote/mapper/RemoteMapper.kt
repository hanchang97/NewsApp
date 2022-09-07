package com.nimok97.newsapp.data.remote.mapper

import com.nimok97.newsapp.data.remote.model.ArticleResponse
import com.nimok97.newsapp.domain.model.NewsItem

object RemoteMapper {
    fun mapToNewsItem(articleResponse: ArticleResponse): NewsItem {
        return NewsItem(
            author = articleResponse.author,
            title = articleResponse.title,
            url = articleResponse.url,
            urlToImage = articleResponse.urlToImage,
            publishedAt = articleResponse.publishedAt,
            content = articleResponse.content
        )
    }
}