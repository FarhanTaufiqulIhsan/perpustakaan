package com.example.perpustakaan.ui.peminjaman.homePeminjaman

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.PeminjamanRepository
import com.example.perpustakaan.model.Peminjaman
import com.example.perpustakaan.ui.HomeUIStateAnggota
import com.example.perpustakaan.ui.HomeUIStatePeminjaman
import com.example.perpustakaan.ui.anggota.homeAnggota.HalamanAnggotaViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed class PeminjamanUIState {
    data class Success(val peminjaman: Flow<List<Peminjaman>>) : PeminjamanUIState()
    object Error : PeminjamanUIState()
    object Loading : PeminjamanUIState()
}

class HalamanPeminjamanViewModel(private val peminjamanRepository: PeminjamanRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUIStatePeminjaman: StateFlow<HomeUIStatePeminjaman> = peminjamanRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIStatePeminjaman (listPeminjaman = it.toList(), it.size)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStatePeminjaman()
        )
}