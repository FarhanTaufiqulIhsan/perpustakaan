package com.example.perpustakaan.ui.buku

import com.example.perpustakaan.model.Anggota
import kotlinx.coroutines.flow.Flow

sealed class BukuUIState {
    data class Success(val buku: Flow<List<Anggota>>) : BukuUIState()
    object Error : BukuUIState()
    object Loading : BukuUIState()
}