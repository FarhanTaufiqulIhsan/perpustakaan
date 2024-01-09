package com.example.perpustakaan.ui.anggota.editAnggota

import com.example.perpustakaan.navigation.DestinasiNavigasi

object EditDestinationAnggota : DestinasiNavigasi {
    override val route = "item edit anggota"
    override val titleRes ="Edit Anggota"
    const val anggotaId = "anggotaId"
    val routeWithArgs = "${EditDestinationAnggota.route}/{$anggotaId}"
}