package com.example.perpustakaan.ui.anggota.editAnggota

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi

object EditDestinationAnggota : DestinasiNavigasi {
    override val route = "item edit anggota"
    override val titleRes ="Edit Anggota"
    const val anggotaId = "anggotaId"
    val routeWithArgs = "${EditDestinationAnggota.route}/{$anggotaId}"
}

@Composable
fun EditScreenAnggota(
    navigateBackAnggota: () -> Unit,
    onNavigateUpAnggota: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()
}