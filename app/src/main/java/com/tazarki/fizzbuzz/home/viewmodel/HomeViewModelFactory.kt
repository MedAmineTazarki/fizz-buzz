package com.tazarki.fizzbuzz.home.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.tazarki.fizzbuzz.CoroutineContexts
import com.tazarki.fizzbuzz.data.RequestRepository

class HomeViewModelFactory(private val app: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(app)
            val requestRepository = RequestRepository(sharedPrefs)

            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(CoroutineContexts, app, requestRepository) as T
        }
        throw IllegalStateException()
    }
}