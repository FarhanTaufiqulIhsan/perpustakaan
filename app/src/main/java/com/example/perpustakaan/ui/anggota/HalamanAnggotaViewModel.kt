package com.example.perpustakaan.ui.anggota

import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.AnggotaRepository
import com.example.perpustakaan.model.Anggota
import kotlinx.coroutines.flow.Flow

sealed class AnggotaUIState {
    data class Success(val anggota: Flow<List<Anggota>>) : AnggotaUIState()
    object Error : AnggotaUIState()
    object Loading : AnggotaUIState()
}

class HomeViewModel(private val anggotaRepository: AnggotaRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}