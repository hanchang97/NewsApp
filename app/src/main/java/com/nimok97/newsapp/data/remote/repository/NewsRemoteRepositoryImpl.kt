package com.nimok97.newsapp.data.remote.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.nimok97.newsapp.data.remote.api.NewsService
import com.nimok97.newsapp.data.remote.datasource.NewsRemotePagingSource
import com.nimok97.newsapp.data.remote.mapper.RemoteMapper
import com.nimok97.newsapp.domain.repository.remote.NewsRemoteRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRemoteRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : NewsRemoteRepository {

    override suspend fun getNewsList(category: String) = Pager(
        config = PagingConfig(pageSize = 5),
        pagingSourceFactory = {
            NewsRemotePagingSource(newsService = newsService, category = category)
        }
    ).flow.map { pagingData ->
        pagingData.map {
            RemoteMapper.mapToNewsItem(it)
        }
    }.catch { e ->
        Log.e("AppTest", "error : ${e}")
    }

}