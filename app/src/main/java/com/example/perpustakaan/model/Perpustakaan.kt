package com.example.perpustakaan.model

import org.threeten.bp.LocalDate

data class Anggota(
    val id: String,
    val nama: String,
    val alamat: String,
    val jk: String,
    val nohp: String
) {
    constructor(): this("","","","", "")
}

data class Buku(
    val id: String,
    val judul: String,
    val pengarang: String,
    val penerbit: String,
    val tahunterbit: String,
    val kategori: String
){
    constructor(): this("","","","","","")
}

data class Peminjaman(
    val id: String,
    val anggota: Anggota,
    val buku: Buku,
    val tanggalPinjam: LocalDate = LocalDate.now(),
    val tanggalKembali: LocalDate = LocalDate.now().plusDays(3)
) {
    constructor(): this("", Anggota(), Buku(), LocalDate.now(), LocalDate.now().plusDays(3))
}