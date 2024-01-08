package com.example.perpustakaan.ui.anggota.addAnggota

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.AddEventAnggota
import com.example.perpustakaan.ui.AddUIStateAnggota

object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Anggota"
}

@Composable
fun AddAnggota(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {}

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