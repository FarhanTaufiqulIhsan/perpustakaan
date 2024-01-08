package com.example.perpustakaan.ui.anggota.detailAnggota

import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationAnggota : DestinasiNavigasi {
    override val route = "item_details_anggota"
    override val titleRes = "Detail Anggota"
    const val anggotaId = "itemAnggotaId"
    val routeWithArgs = "$route/{$anggotaId}"
}