package com.example.perpustakaan.ui.peminjaman.homePeminjaman

import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.PeminjamanRepository
import com.example.perpustakaan.model.Peminjaman
import kotlinx.coroutines.flow.Flow

sealed class PeminjamanUIState {
    data class Success(val peminjaman: Flow<List<Peminjaman>>) : PeminjamanUIState()
    object Error : PeminjamanUIState()
    object Loading : PeminjamanUIState()
}

class HalamanPeminjamanViewModel(private val peminjamanRepository: PeminjamanRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}