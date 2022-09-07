package com.nimok97.newsapp.domain.usecase

import com.nimok97.newsapp.domain.repository.remote.NewsRemoteRepository
import javax.inject.Inject

class GetRemoteNewsListUseCase @Inject constructor(
    private val newsRemoteRepository: NewsRemoteRepository
) {
    suspend operator fun invoke(category: String) =
        newsRemoteRepository.getNewsList(category)
}