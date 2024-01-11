package com.example.perpustakaan.ui.peminjaman.editPeminjaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.R
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.PenyediaViewModel
import com.example.perpustakaan.ui.peminjaman.addPeminjaman.EntryBodyPeminjaman
import kotlinx.coroutines.launch

object EditDestinationPeminjaman : DestinasiNavigasi {
    override val route = "item edit peminjaman"
    override val titleRes = "Edit Peminjaman"
    const val peminjamanId = "peminjamanId"
    val routeWithArgs = "${EditDestinationPeminjaman.route}/{$peminjamanId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenPeminjaman(
    navigateBackPeminjaman: () -> Unit,
    onNavigateUpPeminjaman: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditPeminjamanViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()

    Scaffold() { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg15),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        EntryBodyPeminjaman(
            addUIStatePeminjaman = viewModel.peminjamanUIState,
            onPeminjamanValueChange = viewModel::updateUIStatePeminjaman,
            onSaveClickPeminjaman = { coroutineScope.launch {
                viewModel.updatePeminjaman()
                navigateBackPeminjaman()
            }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}