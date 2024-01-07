package com.example.perpustakaan.ui

import com.example.perpustakaan.model.Anggota

data class HomeUIState(
    val listAnggota: List<Anggota> = listOf(),
    val dataLength: Int = 0
)

data class AddEvent(
    val id: String = "",
    val nama: String = "",
    val alamat: String = "",
    val jk: String = "",
    val nohp: String = ""
)