package com.example.perpustakaan.ui.anggota

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.AnggotaRepository
import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.ui.HomeUIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed class AnggotaUIState {
    data class Success(val anggota: Flow<List<Anggota>>) : AnggotaUIState()
    object Error : AnggotaUIState()
    object Loading : AnggotaUIState()
}

class HomeViewModel(private val anggotaRepository: AnggotaRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUIState: StateFlow<HomeUIState> = anggotaRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIState (listAnggota = it.toList(), it.size)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIState()
        )
}