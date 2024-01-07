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

fun Anggota.toDetailAnggota(): AddEvent =
    AddEvent(
        id = id,
        nama = nama,
        alamat = alamat,
        jk = jk,
        nohp = nohp
    )

fun AddEvent.toAnggota() = Anggota(
    id = id,
    nama = nama,
    alamat = alamat,
    jk = jk,
    nohp = nohp
)

data class AddUIState(
    val addEvent: AddEvent = AddEvent(),
)