package com.example.perpustakaan.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.perpustakaan.PerpusAplication
import com.example.perpustakaan.ui.anggota.addAnggota.AddAnggotaViewModel
import com.example.perpustakaan.ui.anggota.detailAnggota.DetailAnggotaViewModel
import com.example.perpustakaan.ui.anggota.editAnggota.EditAnggotaViewModel
import com.example.perpustakaan.ui.anggota.homeAnggota.HalamanAnggotaViewModel
import com.example.perpustakaan.ui.buku.addBuku.AddBukuViewModel
import com.example.perpustakaan.ui.buku.detailBuku.DetailBukuViewModel
import com.example.perpustakaan.ui.buku.editBuku.EditBukuViewModel
import com.example.perpustakaan.ui.buku.homeBuku.HalamanBukuViewModel
import com.example.perpustakaan.ui.peminjaman.addPeminjaman.AddPeminjamanViewModel
import com.example.perpustakaan.ui.peminjaman.homePeminjaman.HalamanPeminjamanViewModel

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
            DetailAnggotaViewModel(
                createSavedStateHandle(),
                aplikasiPerpus().container.anggotaRepository
            )
        }

        initializer {
            EditAnggotaViewModel(
                createSavedStateHandle(),
                aplikasiPerpus().container.anggotaRepository
            )
        }

        initializer {
            HalamanBukuViewModel(aplikasiPerpus().container.bukuRepository)
        }
        initializer {
            AddBukuViewModel(aplikasiPerpus().container.bukuRepository)
        }
        initializer {
            DetailBukuViewModel(
                createSavedStateHandle(),
                aplikasiPerpus().container.bukuRepository
            )
        }
        initializer {
            EditBukuViewModel(
                createSavedStateHandle(),
                aplikasiPerpus().container.bukuRepository
            )
        }
        initializer {
            HalamanPeminjamanViewModel(aplikasiPerpus().container.peminjamanRepository)
        }
        initializer {
            AddPeminjamanViewModel(aplikasiPerpus().container.peminjamanRepository)
        }
    }
}