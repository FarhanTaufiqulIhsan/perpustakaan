package com.example.perpustakaan.ui.buku.detailBuku

import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationBuku : DestinasiNavigasi{
    override val route = "item_details_buku"
    override val titleRes = "Detail Anggota"
    const val bukuId = "itemBukuId"
    val routeWithArgs = "$route/{$bukuId}"

}

private fun DeleteConfirmationDialog(
    onDeleteConfirmBuku: () -> Unit,
    onDeletecancelmBuku: () -> Unit,
    modifier: Modifier = Modifier
){

}