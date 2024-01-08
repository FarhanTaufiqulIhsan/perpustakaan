package com.example.perpustakaan.ui.buku.homeBuku

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.BukuRepository
import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.ui.HomeUIStateBuku
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed class BukuUIState {
    data class Success(val buku: Flow<List<Anggota>>) : BukuUIState()
    object Error : BukuUIState()
    object Loading : BukuUIState()
}

class HalamanBukuViewModel(private val bukuRepository: BukuRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUIStateBuku: StateFlow<HomeUIStateBuku> = bukuRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIStateBuku (listBuku = it.toList(), it.size)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStateBuku()
        )
}