package com.example.perpustakaan.ui.buku.detailBuku

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DetailDestinationBuku : DestinasiNavigasi{
    override val route = "item_details_buku"
    override val titleRes = "Detail Buku"
    const val bukuId = "itemBukuId"
    val routeWithArgs = "$route/{$bukuId}"

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