package com.example.perpustakaan.ui.buku

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.model.Buku
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

@Composable
fun DataBuku(
    buku: Buku,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {

    }
}