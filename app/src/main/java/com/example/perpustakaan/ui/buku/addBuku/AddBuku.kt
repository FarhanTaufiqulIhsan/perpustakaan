package com.example.perpustakaan.ui.buku.addBuku

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
import com.example.perpustakaan.ui.AddEventBuku
import com.example.perpustakaan.ui.AddUIStateBuku

object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Buku"
}

@Composable
fun AddBuku(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {}

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