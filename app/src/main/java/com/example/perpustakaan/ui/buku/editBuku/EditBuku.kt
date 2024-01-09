package com.example.perpustakaan.ui.buku.editBuku

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.ui.PenyediaViewModel
import com.example.perpustakaan.ui.buku.addBuku.EntryBodyBuku
import kotlinx.coroutines.launch

object EditDestinationBuku : DestinasiNavigasi{
    override val route = "item edit buku"
    override val titleRes = "Edit Buku"
    const val bukuId = "bukuId"
    val routeWithArgs = "${EditDestinationBuku.route}/{$bukuId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenBuku(
    navigateBackBuku: () -> Unit,
    onNavigateUpBuku: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditBukuViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()

    Scaffold() { innerPadding ->
        EntryBodyBuku(
            addUIStateBuku = viewModel.bukuUIState,
            onBukuValueChange = viewModel::updateUIStateBuku,
            onSaveClickBuku = { coroutineScope.launch {
                viewModel.updateBuku()
                navigateBackBuku()
            }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}