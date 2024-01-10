package com.example.perpustakaan.ui

import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.model.Buku
import com.example.perpustakaan.model.Peminjaman
import org.threeten.bp.LocalDate

data class HomeUIStateAnggota(
    val listAnggota: List<Anggota> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStateBuku(
    val listBuku: List<Buku> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStatePeminjaman(
    val listPeminjaman: List<Peminjaman> = listOf(),
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

data class AddEventPeminjaman(
    val id: String = "",
    val anggota: Anggota = Anggota(),
    val buku: Buku = Buku(),
    val tanggalPinjam: LocalDate = LocalDate.now(),
    val tanggalKembali: LocalDate = LocalDate.now().plusDays(3)
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

fun Peminjaman.toDetailPeminjaman(): AddEventPeminjaman =
    AddEventPeminjaman(
        id = id,
        anggota = anggota,
        buku = buku,
        tanggalPinjam = tanggalPinjam,
        tanggalKembali = tanggalKembali
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

fun AddEventPeminjaman.toPeminjaman() = Peminjaman(
    id = id,
    anggota = anggota,
    buku = buku,
    tanggalPinjam = tanggalPinjam,
    tanggalKembali = tanggalKembali
)

data class AddUIStateBuku(
    val addEventBuku: AddEventBuku = AddEventBuku()
)
data class AddUIStateAnggota(
    val addEventAnggota: AddEventAnggota = AddEventAnggota(),
)

data class AddUIStatePeminjaman(
    val addEventPeminjaman: AddEventPeminjaman = AddEventPeminjaman()
)

fun Buku.toUIStateBuku(): AddUIStateBuku = AddUIStateBuku(
    addEventBuku = this.toDetailBuku()
)
fun Anggota.toUIStateAnggota(): AddUIStateAnggota = AddUIStateAnggota(
    addEventAnggota = this.toDetailAnggota()
)

fun Peminjaman.toUIStatePeminjaman(): AddUIStatePeminjaman = AddUIStatePeminjaman(
    addEventPeminjaman = this.toDetailPeminjaman()
)
data class DetailUIStateBuku(
    val addEventBuku: AddEventBuku = AddEventBuku()
)
data class DetailUIStateAnggota(
    val addEventAnggota: AddEventAnggota = AddEventAnggota(),
)
data class DetailUIStatePeminjaman(
    val addEventPeminjaman: AddEventPeminjaman = AddEventPeminjaman()
)