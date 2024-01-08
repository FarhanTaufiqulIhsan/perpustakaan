package com.example.perpustakaan.ui.anggota.detailAnggota

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.AnggotaRepository

class DetailAnggotaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: AnggotaRepository
) : ViewModel() {}