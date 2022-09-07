package com.nimok97.newsapp.data.remote.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.nimok97.newsapp.data.remote.api.NewsService
import com.nimok97.newsapp.data.remote.datasource.NewsRemotePagingSource
import com.nimok97.newsapp.domain.repository.remote.NewsRemoteRepository
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

class NewsRemoteRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : NewsRemoteRepository {

    override suspend fun getNewsList(category: String) = Pager(
        config = PagingConfig(pageSize = 5),
        pagingSourceFactory = {
            NewsRemotePagingSource(newsService = newsService, category = category)
        }
    ).flow.catch { e ->  
        Log.e("AppTest", "error : ${e}")
    }

}