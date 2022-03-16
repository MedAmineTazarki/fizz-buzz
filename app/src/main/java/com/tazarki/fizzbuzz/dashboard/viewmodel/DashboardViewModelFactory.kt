package com.tazarki.fizzbuzz.dashboard.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.tazarki.fizzbuzz.CoroutineContexts
import com.tazarki.fizzbuzz.data.RequestRepository

class DashboardViewModelFactory(private val app: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(app)
            val requestRepository = RequestRepository(sharedPrefs)

            @Suppress("UNCHECKED_CAST")
            return DashboardViewModel(CoroutineContexts, app, requestRepository) as T
        }
        throw IllegalStateException()
    }
}