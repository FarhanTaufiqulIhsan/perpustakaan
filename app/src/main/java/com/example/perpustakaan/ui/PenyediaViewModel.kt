package com.example.perpustakaan.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.perpustakaan.PerpusAplication
import com.example.perpustakaan.ui.anggota.addAnggota.AddAnggotaViewModel
import com.example.perpustakaan.ui.anggota.homeAnggota.HalamanAnggotaViewModel
import com.example.perpustakaan.ui.buku.addBuku.AddBukuViewModel
import com.example.perpustakaan.ui.buku.homeBuku.HalamanBukuViewModel

fun CreationExtras.aplikasiPerpus(): PerpusAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PerpusAplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HalamanAnggotaViewModel(aplikasiPerpus().container.anggotaRepository)
        }

        initializer {
            AddAnggotaViewModel(aplikasiPerpus().container.anggotaRepository)
        }

        initializer {
            HalamanBukuViewModel(aplikasiPerpus().container.bukuRepository)
        }
        initializer {
            AddBukuViewModel(aplikasiPerpus().container.bukuRepository)
        }
    }
}