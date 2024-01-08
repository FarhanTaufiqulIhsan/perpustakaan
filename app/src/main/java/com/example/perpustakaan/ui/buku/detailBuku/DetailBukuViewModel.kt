package com.example.perpustakaan.ui.buku.detailBuku

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.BukuRepository

class DetailBukuViewModel (
    savedStateHandle: SavedStateHandle,
    private val repository: BukuRepository
) : ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val bukuId: String = checkNotNull(savedStateHandle[DetailDestinationBuku.bukuId])
}