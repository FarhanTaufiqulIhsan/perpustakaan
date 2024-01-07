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