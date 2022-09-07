package com.nimok97.newsapp.di

import com.nimok97.newsapp.domain.repository.remote.NewsRemoteRepository
import com.nimok97.newsapp.domain.usecase.GetRemoteNewsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Singleton
    @Provides
    fun provideGetRemoteNewsListUseCase(newsRemoteRepository: NewsRemoteRepository) =
        GetRemoteNewsListUseCase(newsRemoteRepository)
}