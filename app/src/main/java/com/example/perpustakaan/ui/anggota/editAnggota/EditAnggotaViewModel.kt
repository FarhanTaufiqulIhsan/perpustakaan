package com.example.perpustakaan.ui.anggota.editAnggota

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.AnggotaRepository
import com.example.perpustakaan.ui.AddUIStateAnggota
import com.example.perpustakaan.ui.toUIStateAnggota
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditAnggotaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: AnggotaRepository
) : ViewModel() {
    var anggotaUIState by mutableStateOf(AddUIStateAnggota())
        private set

    private val anggotaId: String = checkNotNull(savedStateHandle[EditDestinationAnggota.anggotaId])

    init {
        viewModelScope.launch {
            anggotaUIState =
                repository.getAnggotaById(anggotaId)
                    .filterNotNull()
                    .first()
                    .toUIStateAnggota()
        }
    }
}