package com.example.perpustakaan.ui.peminjaman.editPeminjaman

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.PeminjamanRepository
import com.example.perpustakaan.ui.AddEventPeminjaman
import com.example.perpustakaan.ui.AddUIStatePeminjaman
import com.example.perpustakaan.ui.toPeminjaman
import com.example.perpustakaan.ui.toUIStatePeminjaman
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditPeminjamanViewModel (
    savedStateHandle: SavedStateHandle,
    private val repository: PeminjamanRepository
) : ViewModel(){
    var peminjamanUIState by mutableStateOf(AddUIStatePeminjaman())
        private set

    private val peminjamanId: String = checkNotNull(savedStateHandle[EditDestinationPeminjaman.peminjamanId])

    init {
        viewModelScope.launch {
            peminjamanUIState =
                repository.getPeminjamanById(peminjamanId)
                    .filterNotNull()
                    .first()
                    .toUIStatePeminjaman()
        }
    }

    fun updateUIStatePeminjaman(addEventPeminjaman: AddEventPeminjaman){
        peminjamanUIState = peminjamanUIState.copy(addEventPeminjaman = addEventPeminjaman)
    }

    suspend fun updatePeminjaman(){
        repository.update(peminjamanUIState.addEventPeminjaman.toPeminjaman())
    }
}