package com.example.perpustakaan.ui.peminjaman.homePeminjaman

import com.example.perpustakaan.model.Peminjaman
import kotlinx.coroutines.flow.Flow

sealed class PeminjamanUIState {
    data class Success(val peminjaman: Flow<List<Peminjaman>>) : PeminjamanUIState()
    object Error : PeminjamanUIState()
    object Loading : PeminjamanUIState()
}
