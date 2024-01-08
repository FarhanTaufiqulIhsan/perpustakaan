package com.example.perpustakaan.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.perpustakaan.PerpusAplication
import com.example.perpustakaan.ui.anggota.HalamanAnggotaViewModel

fun CreationExtras.aplikasiPerpus(): PerpusAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PerpusAplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HalamanAnggotaViewModel(aplikasiPerpus().container.anggotaRepository)
        }
    }
}