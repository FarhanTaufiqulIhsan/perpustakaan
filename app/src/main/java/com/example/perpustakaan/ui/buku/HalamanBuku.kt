package com.example.perpustakaan.ui.buku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = buku.judul,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
                Text(
                    text = buku.pengarang,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = buku.kategori,
                    style = MaterialTheme.typography.titleLarge,
                    )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
                Text(
                    text = buku.tahunterbit,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}