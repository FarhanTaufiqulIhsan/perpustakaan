package com.example.perpustakaan.ui.anggota.detailAnggota

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.AnggotaRepository

class DetailAnggotaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: AnggotaRepository
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val anggotaId: String = checkNotNull(savedStateHandle[DetailDestinationAnggota.anggotaId])
}