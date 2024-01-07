package com.example.perpustakaan.ui.anggota

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Anggota"
}

@Composable
fun AnggotaScreen(
    navigateToItemEntryAnggota: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
) {}

@Composable
fun DataAnggota(
    anggota: Anggota,
    modifier: Modifier = Modifier
) {}