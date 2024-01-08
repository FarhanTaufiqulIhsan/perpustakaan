package com.example.perpustakaan.ui

import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.model.Buku

data class HomeUIStateAnggota(
    val listAnggota: List<Anggota> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStateBuku(
    val listBuku: List<Buku> = listOf(),
    val dataLength: Int = 0
)
data class AddEventAnggota(
    val id: String = "",
    val nama: String = "",
    val alamat: String = "",
    val jk: String = "",
    val nohp: String = ""
)

fun Anggota.toDetailAnggota(): AddEventAnggota =
    AddEventAnggota(
        id = id,
        nama = nama,
        alamat = alamat,
        jk = jk,
        nohp = nohp
    )

fun AddEventAnggota.toAnggota() = Anggota(
    id = id,
    nama = nama,
    alamat = alamat,
    jk = jk,
    nohp = nohp
)

data class AddUIStateAnggota(
    val addEventAnggota: AddEventAnggota = AddEventAnggota(),
)

fun Anggota.toUIStateAnggota(): AddUIStateAnggota = AddUIStateAnggota(
    addEventAnggota = this.toDetailAnggota()
)

data class DetailUIStateAnggota(
    val addEventAnggota: AddEventAnggota = AddEventAnggota(),
)