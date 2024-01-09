package com.example.perpustakaan.ui.anggota.editAnggota

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.AnggotaRepository
import com.example.perpustakaan.ui.AddUIStateAnggota

class EditAnggotaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: AnggotaRepository
) : ViewModel() {
    var anggotaUIState by mutableStateOf(AddUIStateAnggota())
        private set
}