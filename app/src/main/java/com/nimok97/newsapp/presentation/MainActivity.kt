package com.nimok97.newsapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.nimok97.newsapp.BuildConfig
import com.nimok97.newsapp.R
import com.nimok97.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var mainNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Log.e("AppTest", "DEBUG? : ${BuildConfig.DEBUG}")

        initView()
        observeMoveEvent()
    }

    private fun initView() {
        setBottomNavigationView()
    }

    private fun setBottomNavigationView() {
        binding.mainBnv.itemIconTintList = null

        supportFragmentManager.findFragmentById(R.id.main_fcv)?.findNavController()?.let {
            mainNavController = it
        }
        binding.mainBnv.setupWithNavController(mainNavController)
    }

    private fun observeMoveEvent() {
        mainViewModel.eventCategoriesToCategoryNews.flowWithLifecycle(lifecycle).onEach {
            if(it) {
                Log.e(this.javaClass.simpleName, "observe event")
                mainNavController.navigate(R.id.action_categoriesFragment_to_categoryNewsFragment)
            }
        }.launchIn(lifecycleScope)
    }

}