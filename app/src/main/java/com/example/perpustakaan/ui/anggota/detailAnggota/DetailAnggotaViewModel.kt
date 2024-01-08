package com.example.perpustakaan.ui.anggota.detailAnggota

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.AnggotaRepository
import com.example.perpustakaan.ui.DetailUIStateAnggota
import com.example.perpustakaan.ui.toDetailAnggota
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailAnggotaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: AnggotaRepository
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val anggotaId: String = checkNotNull(savedStateHandle[DetailDestinationAnggota.anggotaId])

    val uiStateAnggota: StateFlow<DetailUIStateAnggota> =
        repository.getAnggotaById(anggotaId)
            .filterNotNull()
            .map {
                DetailUIStateAnggota(addEventAnggota = it.toDetailAnggota())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailUIStateAnggota()
            )

    suspend fun deleteAnggota() {
        repository.delete(anggotaId)
    }
}