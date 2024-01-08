package com.example.perpustakaan.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.perpustakaan.PerpusAplication

fun CreationExtras.aplikasiPerpus(): PerpusAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PerpusAplication)