package com.example.perpustakaan.ui.buku.addBuku

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.AddEventBuku

object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Buku"
}

@Composable
fun FormInputBuku(
    addEventBuku: AddEventBuku,
    modifier: Modifier = Modifier,
    onValueChangeBuku: (AddEventBuku) -> Unit = {},
    enabled: Boolean = true
) {}