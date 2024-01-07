package com.example.perpustakaan.ui.anggota

import com.example.perpustakaan.model.Anggota
import kotlinx.coroutines.flow.Flow

sealed class AnggotaUIState {
    data class Success(val anggota: Flow<List<Anggota>>) : AnggotaUIState()
    object Error : AnggotaUIState()
    object Loading : AnggotaUIState()
}