package com.nimok97.newsapp.data.remote.api

import com.nimok97.newsapp.data.remote.common.API_KEY
import com.nimok97.newsapp.data.remote.model.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    suspend fun getNewsList(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("pageSize") pageSize: Int = 5,
        @Query("page") page: Int = 1
    ): Response<NewsApiResponse>
}