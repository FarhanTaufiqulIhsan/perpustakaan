package com.example.perpustakaan.ui.buku.detailBuku

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationBuku : DestinasiNavigasi{
    override val route = "item_details_buku"
    override val titleRes = "Detail Anggota"
    const val bukuId = "itemBukuId"
    val routeWithArgs = "$route/{$bukuId}"

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