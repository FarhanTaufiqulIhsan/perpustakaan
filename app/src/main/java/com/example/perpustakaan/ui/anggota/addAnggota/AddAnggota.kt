package com.example.perpustakaan.ui.anggota.addAnggota

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.AddEventAnggota

object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Anggota"
}

@Composable
fun FormInputAnggota(
    addEventAnggota: AddEventAnggota,
    modifier: Modifier = Modifier,
    onValueChange: (AddEventAnggota) -> Unit = {},
    enabled: Boolean = true
) {}