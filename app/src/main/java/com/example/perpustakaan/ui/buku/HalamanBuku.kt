package com.example.perpustakaan.ui.buku

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DestinasiHome: DestinasiNavigasi{
    override val route = "home"
    override val titleRes = "Buku"
}

@Composable
fun BukuScreen(
    navigateToItemEntryBuku: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
) {}