package com.nimok97.newsapp.di

import com.nimok97.newsapp.data.remote.api.NewsService
import com.nimok97.newsapp.data.remote.repository.NewsRemoteRepositoryImpl
import com.nimok97.newsapp.domain.repository.remote.NewsRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRemoteRepository(newsService: NewsService): NewsRemoteRepository =
        NewsRemoteRepositoryImpl(newsService)
}