package com.example.perpustakaan.ui.peminjaman.detailPeminjaman

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.PeminjamanRepository
import com.example.perpustakaan.ui.DetailUIStatePeminjaman
import com.example.perpustakaan.ui.toDetailPeminjaman
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailPeminjamanViewModel (
    savedStateHandle: SavedStateHandle,
    private val repository: PeminjamanRepository
) : ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val peminjamanId: String = checkNotNull(savedStateHandle[DetailDestinationPeminjaman.peminjamanId])

    val uiStatePeminjaman: StateFlow<DetailUIStatePeminjaman> =
        repository.getPeminjamanById(peminjamanId)
            .filterNotNull()
            .map {
                DetailUIStatePeminjaman(addEventPeminjaman = it.toDetailPeminjaman())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailUIStatePeminjaman()
            )
    suspend fun deletePeminjaman(){
        repository.delete(peminjamanId)
    }
}