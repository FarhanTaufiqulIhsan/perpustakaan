package com.example.perpustakaan.model

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

}