package com.nimok97.newsapp.data.remote.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nimok97.newsapp.data.remote.api.NewsService
import com.nimok97.newsapp.data.remote.common.API_KEY
import com.nimok97.newsapp.data.remote.mapper.RemoteMapper
import com.nimok97.newsapp.domain.model.NewsItem

private const val STARTING_PAGING_INDEX = 1

class NewsRemotePagingSource(
    private val newsService: NewsService,
    private val category: String
) : PagingSource<Int, NewsItem>() {
    override fun getRefreshKey(state: PagingState<Int, NewsItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsItem> {
        val page = params.key ?: STARTING_PAGING_INDEX
        return try {
            Log.e("NewsRemotePagingSource", "try load")
            val response = newsService.getNewsList(
                country = "us",
                category = category,
                apiKey = API_KEY,
                pageSize = 5,
                page = page
            )

            val newsItems = response.body()?.articleResponses?.map {
                RemoteMapper.mapToNewsItem(it)
            } ?: listOf()
            Log.e("NewsRemotePagingSource", "list size : ${newsItems.size}")

            LoadResult.Page(
                data = newsItems,
                prevKey = if (page == STARTING_PAGING_INDEX) null else page - 1,
                nextKey = if (newsItems.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            Log.e("NewsRemotePagingSource", "exception : ${e}")
            LoadResult.Error(e)
        }
    }
}