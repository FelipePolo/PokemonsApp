package com.felipepolo.pokemonappmvvm

import android.app.Application
import com.felipepolo.pokemonappmvvm.di.AppComponent
import com.felipepolo.pokemonappmvvm.di.DaggerAppComponent

class TodoApplication: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}