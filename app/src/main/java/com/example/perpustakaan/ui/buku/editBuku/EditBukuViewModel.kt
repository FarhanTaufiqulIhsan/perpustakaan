package com.example.perpustakaan.ui.buku.editBuku

import androidx.lifecycle.SavedStateHandle
import com.example.perpustakaan.data.BukuRepository

class EditBukuViewModel (
    savedStateHandle: SavedStateHandle,
    private val repository: BukuRepository
)