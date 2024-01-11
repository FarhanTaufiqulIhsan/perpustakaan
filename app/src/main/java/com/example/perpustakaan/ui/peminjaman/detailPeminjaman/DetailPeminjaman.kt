package com.example.perpustakaan.ui.peminjaman.detailPeminjaman

import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationPeminjaman : DestinasiNavigasi {
    override val route = "item_details_peminjaman"
    override val titleRes = "Detail Peminjaman"
    const val peminjamanId = "itemPeminjamanId"
    val routeWithArgs = "$route/{$peminjamanId}"

}