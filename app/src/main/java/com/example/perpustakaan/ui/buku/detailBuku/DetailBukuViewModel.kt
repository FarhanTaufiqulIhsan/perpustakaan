package com.example.perpustakaan.ui.buku.detailBuku

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.BukuRepository
import com.example.perpustakaan.ui.DetailUIStateBuku
import com.example.perpustakaan.ui.toDetailBuku
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailBukuViewModel (
    savedStateHandle: SavedStateHandle,
    private val repository: BukuRepository
) : ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val bukuId: String = checkNotNull(savedStateHandle[DetailDestinationBuku.bukuId])

    val uiStateBuku: StateFlow<DetailUIStateBuku> =
        repository.getBukuById(bukuId)
            .filterNotNull()
            .map {
                DetailUIStateBuku(addEventBuku = it.toDetailBuku())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailUIStateBuku()
            )

    suspend fun deleteBuku(){
        repository.delete(bukuId)
    }
}