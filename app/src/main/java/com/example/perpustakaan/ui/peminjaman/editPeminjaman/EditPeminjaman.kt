package com.example.perpustakaan.ui.peminjaman.editPeminjaman

import com.example.perpustakaan.navigation.DestinasiNavigasi

object EditDestinationPeminjaman : DestinasiNavigasi {
    override val route = "item edit peminjaman"
    override val titleRes = "Edit Peminjaman"
    const val peminjamanId = "peminjamanId"
    val routeWithArgs = "${EditDestinationPeminjaman.route}/{$peminjamanId}"
}