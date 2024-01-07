package com.example.perpustakaan

import android.app.Application
import com.example.perpustakaan.data.AppContainer
import com.example.perpustakaan.data.PerpusContainer

class PerpusAplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = PerpusContainer()
    }
}