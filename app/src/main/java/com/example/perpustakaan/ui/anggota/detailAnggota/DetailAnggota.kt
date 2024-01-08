package com.example.perpustakaan.ui.anggota.detailAnggota

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationAnggota : DestinasiNavigasi {
    override val route = "item_details_anggota"
    override val titleRes = "Detail Anggota"
    const val anggotaId = "itemAnggotaId"
    val routeWithArgs = "$route/{$anggotaId}"
}

@Composable
private fun ItemDetailsRowAnggota(
    labelResIDAnggota: String,
    itemDetailAnggota: String,
    modifier: Modifier = Modifier
) {}

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