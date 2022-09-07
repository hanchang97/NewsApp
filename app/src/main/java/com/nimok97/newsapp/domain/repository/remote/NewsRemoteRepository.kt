package com.nimok97.newsapp.domain.repository.remote

import androidx.paging.PagingData
import com.nimok97.newsapp.domain.model.NewsItem
import kotlinx.coroutines.flow.Flow

interface NewsRemoteRepository {
    suspend fun getNewsList(category: String): Flow<PagingData<NewsItem>>
}