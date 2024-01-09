package com.example.perpustakaan.ui.buku.editBuku

import com.example.perpustakaan.navigation.DestinasiNavigasi

object EditDestinationBuku : DestinasiNavigasi{
    override val route = "item edit buku"
    override val titleRes = "Edit Buku"
    const val bukuId = "bukuId"
    val routeWithArgs = "${EditDestinationBuku.route}/{$bukuId}"
}