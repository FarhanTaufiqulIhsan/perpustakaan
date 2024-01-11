package com.example.perpustakaan.ui.anggota.addAnggota

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
import com.example.perpustakaan.ui.AddEventAnggota
import com.example.perpustakaan.ui.AddUIStateAnggota
import com.example.perpustakaan.ui.AnggotaTopAppBar
import com.example.perpustakaan.ui.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiEntryAnggota : DestinasiNavigasi {
    override val route = "item entry anggota"
    override val titleRes = "Entry Anggota"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAnggota(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addAnggotaViewModel: AddAnggotaViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AnggotaTopAppBar(
                title = DestinasiEntryAnggota.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
        ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg14),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        EntryBodyAnggota(
            addUIStateAnggota = addAnggotaViewModel.addUIStateAnggota,
            onAnggotaValueChange = addAnggotaViewModel::updateAddUIStateAnggota,
            onSaveClickAnggota = {
                coroutineScope.launch {
                    addAnggotaViewModel.addAnggota()
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
fun EntryBodyAnggota(
    addUIStateAnggota: AddUIStateAnggota,
    onAnggotaValueChange: (AddEventAnggota) -> Unit,
    onSaveClickAnggota: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInputAnggota(
            addEventAnggota = addUIStateAnggota.addEventAnggota,
            onValueChangeAnggota = onAnggotaValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        
        Button(
            onClick = onSaveClickAnggota,
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
fun FormInputAnggota(
    addEventAnggota: AddEventAnggota,
    modifier: Modifier = Modifier,
    onValueChangeAnggota: (AddEventAnggota) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = addEventAnggota.nama,
            onValueChange = { onValueChangeAnggota(addEventAnggota.copy(nama = it)) },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventAnggota.alamat,
            onValueChange = { onValueChangeAnggota(addEventAnggota.copy(alamat = it)) },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventAnggota.jk,
            onValueChange = { onValueChangeAnggota(addEventAnggota.copy(jk = it)) },
            label = { Text("Jenis Kelamin") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventAnggota.nohp,
            onValueChange = { onValueChangeAnggota(addEventAnggota.copy(nohp = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Nomor Telepon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}