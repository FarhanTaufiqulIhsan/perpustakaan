package com.example.perpustakaan.ui.anggota.detailAnggota

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationAnggota : DestinasiNavigasi {
    override val route = "item_details_anggota"
    override val titleRes = "Detail Anggota"
    const val anggotaId = "itemAnggotaId"
    val routeWithArgs = "$route/{$anggotaId}"
}

@Composable
fun ItemDetails(
    anggota: Anggota,
    modifier: Modifier = Modifier
) {}

@Composable
private fun ItemDetailsRowAnggota(
    labelResIDAnggota: String,
    itemDetailAnggota: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = labelResIDAnggota, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetailAnggota, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirmAnggota: () -> Unit,
    onDeleteCancelAnggota: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text("Are you sure")},
        text = { Text("Delete")},
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancelAnggota) {
                Text(text = "No")
        }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirmAnggota) {
                Text(text = "Yes")
            }
        }
    )
}