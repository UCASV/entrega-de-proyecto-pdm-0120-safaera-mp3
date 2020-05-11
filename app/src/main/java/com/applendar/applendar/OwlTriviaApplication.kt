package com.applendar.applendar

import android.app.Application
import timber.log.Timber

class OwlTriviaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}