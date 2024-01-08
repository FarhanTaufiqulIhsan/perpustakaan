package com.example.perpustakaan.ui.buku.detailBuku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.perpustakaan.model.Buku
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationBuku : DestinasiNavigasi{
    override val route = "item_details_buku"
    override val titleRes = "Detail Buku"
    const val bukuId = "itemBukuId"
    val routeWithArgs = "$route/{$bukuId}"

}

@Composable
fun ItemDetailsBuku(
    buku: Buku,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ItemDetailsRowBuku(
                labelResIDBuku = "Nama",
                itemDetailBuku = buku.judul,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowBuku(
                labelResIDBuku = "Pengarang",
                itemDetailBuku = buku.pengarang,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowBuku(
                labelResIDBuku = "Penerbit",
                itemDetailBuku = buku.tahunterbit,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowBuku(
                labelResIDBuku = "Tahun Terbit",
                itemDetailBuku = buku.tahunterbit,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowBuku(
                labelResIDBuku = "Kategori",
                itemDetailBuku = buku.kategori,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
        }
    }
}

@Composable
private fun ItemDetailsRowBuku(
    labelResIDBuku: String,
    itemDetailBuku: String,
    modifier: Modifier =Modifier
){
    Row (modifier = modifier){
        Text(text = labelResIDBuku, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetailBuku, fontWeight = FontWeight.Bold)

    }
}

@Composable
private fun DeleteConfirmationDialogBuku(
    onDeleteConfirmBuku: () -> Unit,
    onDeletecancelmBuku: () -> Unit,
    modifier: Modifier = Modifier
){
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text("Are you sure")},
        text = { Text("Delete")},
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeletecancelmBuku) {
                Text(text = "No")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirmBuku) {
                Text(text = "Yes")
            }
        }
    )
}