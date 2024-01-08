package com.example.perpustakaan.ui.buku

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
fun BodyHomeBuku(
    itemBuku: List<Buku>,
    modifier: Modifier = Modifier,
    onBukuClick: (String) -> Unit = {}
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemBuku.isEmpty()){
            Text(
                text = "Tidak ada data Buku",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListBuku(
                itemBuku = itemBuku,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onBukuClick(it.id) }
            )
        }
    }
}
@Composable
fun ListBuku(
    itemBuku: List<Buku>,
    modifier: Modifier = Modifier,
    onItemClick: (Buku) -> Unit
){
    LazyColumn(
        modifier = modifier
    ){
        this.items(itemBuku, key = {it.id}){buku ->
            DataBuku(
                buku = buku,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(buku) }
            )
        }
    }
}
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