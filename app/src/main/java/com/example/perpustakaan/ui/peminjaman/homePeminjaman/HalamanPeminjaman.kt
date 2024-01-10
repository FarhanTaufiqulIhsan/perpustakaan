package com.example.perpustakaan.ui.peminjaman.homePeminjaman

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.perpustakaan.model.Peminjaman
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DestinasiHomePeminjaman : DestinasiNavigasi {
    override val route = "home peminjaman"
    override val titleRes = "Peminjaman"
}

@Composable
fun DataPeminjaman(
    peminjaman: Peminjaman,
    modifier: Modifier = Modifier
) {}