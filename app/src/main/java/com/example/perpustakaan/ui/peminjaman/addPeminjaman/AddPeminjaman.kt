package com.example.perpustakaan.ui.peminjaman.addPeminjaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.R
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.AddEventPeminjaman
import com.example.perpustakaan.ui.AddUIStatePeminjaman
import com.example.perpustakaan.ui.PeminjamanTopAppBar
import com.example.perpustakaan.ui.PenyediaViewModel
import kotlinx.coroutines.launch


object DestinasiEntryPeminjaman : DestinasiNavigasi {
    override val route = "item entry peminjaman"
    override val titleRes = "Entry Peminjaman"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPeminjaman(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addPeminjamanViewModel: AddPeminjamanViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PeminjamanTopAppBar(
                title = DestinasiEntryPeminjaman.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg15),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        EntryBodyPeminjaman(
            addUIStatePeminjaman = addPeminjamanViewModel.addUIStatePeminjaman,
            onPeminjamanValueChange = addPeminjamanViewModel::updateAddUIStatePeminjaman,
            onSaveClickPeminjaman = {
                coroutineScope.launch {
                    addPeminjamanViewModel.addPeminjaman()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}
@Composable
fun EntryBodyPeminjaman(
    addUIStatePeminjaman: AddUIStatePeminjaman,
    onPeminjamanValueChange: (AddEventPeminjaman) -> Unit,
    onSaveClickPeminjaman: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInputPeminjaman(
            addEventPeminjaman = addUIStatePeminjaman.addEventPeminjaman,
            onValueChangePeminjaman = onPeminjamanValueChange,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onSaveClickPeminjaman,
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightbrown)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}
@Composable
fun FormInputPeminjaman(
    addEventPeminjaman: AddEventPeminjaman,
    modifier: Modifier = Modifier,
    onValueChangePeminjaman: (AddEventPeminjaman) -> Unit = {},
    enabled: Boolean = true
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = addEventPeminjaman.anggota,
            onValueChange = { onValueChangePeminjaman(addEventPeminjaman.copy(anggota = it)) },
            label = { Text(text = "Anggota") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventPeminjaman.buku,
            onValueChange = { onValueChangePeminjaman(addEventPeminjaman.copy(buku = it)) },
            label = { Text(text = "Buku") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventPeminjaman.tanggalpinjam,
            onValueChange = { onValueChangePeminjaman(addEventPeminjaman.copy(tanggalpinjam = it)) },
            label = { Text(text = "Tanggal Pinjam") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventPeminjaman.tanggalbalik,
            onValueChange = { onValueChangePeminjaman(addEventPeminjaman.copy(tanggalbalik = it)) },
            label = { Text(text = "Tanggal Balik") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )


    }
}
