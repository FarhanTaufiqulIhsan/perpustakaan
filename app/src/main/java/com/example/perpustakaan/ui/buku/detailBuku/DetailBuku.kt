package com.example.perpustakaan.ui.buku.detailBuku

import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationBuku : DestinasiNavigasi{
    override val route = "item_details_buku"
    override val titleRes = "Detail Anggota"
    const val bukuId = "itemBukuId"
    val routeWithArgs = "$route/{$bukuId}"

}