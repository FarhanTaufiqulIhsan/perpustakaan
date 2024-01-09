package com.example.perpustakaan.ui.anggota.editAnggota

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.PenyediaViewModel
import com.example.perpustakaan.ui.anggota.addAnggota.EntryBodyAnggota
import kotlinx.coroutines.launch

object EditDestinationAnggota : DestinasiNavigasi {
    override val route = "item edit anggota"
    override val titleRes ="Edit Anggota"
    const val anggotaId = "anggotaId"
    val routeWithArgs = "${EditDestinationAnggota.route}/{$anggotaId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenAnggota(
    navigateBackAnggota: () -> Unit,
    onNavigateUpAnggota: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditAnggotaViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold() { innerPadding ->
        EntryBodyAnggota(
            addUIStateAnggota = viewModel.anggotaUIState,
            onAnggotaValueChange = viewModel::updateUIStateAnggota,
            onSaveClickAnggota = {
                coroutineScope.launch {
                    viewModel.updateAnggota()
                    navigateBackAnggota()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}