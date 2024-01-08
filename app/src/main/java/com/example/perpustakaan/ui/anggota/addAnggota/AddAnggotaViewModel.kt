package com.example.perpustakaan.ui.anggota.addAnggota

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.AnggotaRepository
import com.example.perpustakaan.ui.AddUIStateAnggota

class AddAnggotaViewModel(private val anggotaRepository: AnggotaRepository) : ViewModel() {
    var addUIStateAnggota by mutableStateOf(AddUIStateAnggota())
        private set
}