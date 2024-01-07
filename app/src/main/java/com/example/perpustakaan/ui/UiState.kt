package com.example.perpustakaan.ui

import com.example.perpustakaan.model.Anggota

data class HomeUIState(
    val listAnggota: List<Anggota> = listOf(),
    val dataLength: Int = 0
)