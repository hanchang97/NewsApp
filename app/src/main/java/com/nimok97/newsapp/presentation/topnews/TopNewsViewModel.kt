package com.nimok97.newsapp.presentation.topnews

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.nimok97.newsapp.domain.model.NewsItem
import com.nimok97.newsapp.domain.usecase.GetRemoteNewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopNewsViewModel @Inject constructor(
    private val getRemoteNewsListUseCase: GetRemoteNewsListUseCase
) : ViewModel() {

    companion object{
        private val TAG = "TopNewsViewModel"
    }

    private val _topNewsPagingData = MutableStateFlow<PagingData<NewsItem>>(PagingData.empty())
    val topNewsPagingData: StateFlow<PagingData<NewsItem>> get() = _topNewsPagingData

    init {
        getNewsList()
    }

    fun getNewsList() {
        viewModelScope.launch {
            getRemoteNewsListUseCase("").cachedIn(viewModelScope).collect {
                _topNewsPagingData.value = it
                Log.e(TAG, " success : ${it}")
            }
        }
    }
}