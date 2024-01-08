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

data class AddEventBuku(
    val id: String = "",
    val judul: String = "",
    val pengarang: String = "",
    val penerbit: String = "",
    val tahunterbit: String = "",
    val kategori: String = ""
)
fun Buku.toDetailBuku(): AddEventBuku =
    AddEventBuku(
        id = id,
        judul = judul,
        pengarang = pengarang,
        penerbit = penerbit,
        tahunterbit = tahunterbit,
        kategori = kategori
    )
fun Anggota.toDetailAnggota(): AddEventAnggota =
    AddEventAnggota(
        id = id,
        nama = nama,
        alamat = alamat,
        jk = jk,
        nohp = nohp
    )

fun AddEventBuku.toBuku() = Buku(
    id = id,
    judul = judul,
    pengarang = pengarang,
    penerbit = penerbit,
    tahunterbit = tahunterbit,
    kategori = kategori
)

fun AddEventAnggota.toAnggota() = Anggota(
    id = id,
    nama = nama,
    alamat = alamat,
    jk = jk,
    nohp = nohp
)
data class AddUIStateBuku(
    val addEventBuku: AddEventBuku = AddEventBuku()
)
data class AddUIStateAnggota(
    val addEventAnggota: AddEventAnggota = AddEventAnggota(),
)

fun Buku.toUIStateBuku(): AddUIStateBuku = AddUIStateBuku(
    addEventBuku = this.toDetailBuku()
)
fun Anggota.toUIStateAnggota(): AddUIStateAnggota = AddUIStateAnggota(
    addEventAnggota = this.toDetailAnggota()
)

data class DetailUIStateAnggota(
    val addEventAnggota: AddEventAnggota = AddEventAnggota(),
)