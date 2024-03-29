package com.example.perpustakaan.ui.buku.addBuku

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.R
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.AddEventBuku
import com.example.perpustakaan.ui.AddUIStateBuku
import com.example.perpustakaan.ui.BukuTopAppBar
import com.example.perpustakaan.ui.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiEntryBuku : DestinasiNavigasi {
    override val route = "item entry buku"
    override val titleRes = "Entry Buku"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBuku(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addBukuViewModel: AddBukuViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BukuTopAppBar(
                title = DestinasiEntryBuku.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg9),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        EntryBodyBuku(
            addUIStateBuku = addBukuViewModel.addUIStateBuku,
            onBukuValueChange = addBukuViewModel::updateAddUIStateBuku,
            onSaveClickBuku = {
                coroutineScope.launch {
                    addBukuViewModel.addBuku()
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
fun EntryBodyBuku(
    addUIStateBuku: AddUIStateBuku,
    onBukuValueChange: (AddEventBuku) -> Unit,
    onSaveClickBuku: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInputBuku(
            addEventBuku = addUIStateBuku.addEventBuku,
            onValueChangeBuku = onBukuValueChange,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onSaveClickBuku,
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightbrown)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputBuku(
    addEventBuku: AddEventBuku,
    modifier: Modifier = Modifier,
    onValueChangeBuku: (AddEventBuku) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = addEventBuku.judul,
            onValueChange = { onValueChangeBuku(addEventBuku.copy(judul = it)) },
            label = { Text("Judul") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventBuku.pengarang,
            onValueChange = { onValueChangeBuku(addEventBuku.copy(pengarang = it)) },
            label = { Text("Pengarang") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventBuku.penerbit,
            onValueChange = { onValueChangeBuku(addEventBuku.copy(penerbit = it)) },
            label = { Text("Penerbit") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventBuku.tahunterbit,
            onValueChange = { onValueChangeBuku(addEventBuku.copy(tahunterbit = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Tahun Terbit") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventBuku.kategori,
            onValueChange = { onValueChangeBuku(addEventBuku.copy(kategori = it)) },
            label = { Text("Kategori") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}