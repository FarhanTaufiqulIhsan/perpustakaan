package com.example.perpustakaan.ui.buku.editBuku

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.ui.PenyediaViewModel

object EditDestinationBuku : DestinasiNavigasi{
    override val route = "item edit buku"
    override val titleRes = "Edit Buku"
    const val bukuId = "bukuId"
    val routeWithArgs = "${EditDestinationBuku.route}/{$bukuId}"
}

@Composable
fun EditScreenBuku(
    navigateBackBuku: () -> Unit,
    onNavigateUpBuku: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditBukuViewModel = viewModel(factory = PenyediaViewModel.Factory)
){

}