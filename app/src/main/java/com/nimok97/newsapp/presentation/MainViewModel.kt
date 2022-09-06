package com.nimok97.newsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _eventCategoriesToCategoryNews = MutableSharedFlow<Boolean>()
    val eventCategoriesToCategoryNews = _eventCategoriesToCategoryNews.asSharedFlow()

    fun moveCategoriesToCategoryNews() {
        viewModelScope.launch {
            _eventCategoriesToCategoryNews.emit(true)
        }
    }
}