package com.example.perpustakaan.ui.peminjaman.detailPeminjaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.R
import com.example.perpustakaan.model.Peminjaman
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.DetailUIStatePeminjaman
import com.example.perpustakaan.ui.PeminjamanTopAppBar
import com.example.perpustakaan.ui.PenyediaViewModel
import com.example.perpustakaan.ui.toPeminjaman
import kotlinx.coroutines.launch

object DetailDestinationPeminjaman : DestinasiNavigasi {
    override val route = "item_details_peminjaman"
    override val titleRes = "Detail Peminjaman"
    const val peminjamanId = "itemPeminjamanId"
    val routeWithArgs = "$route/{$peminjamanId}"

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenPeminjaman(
    navigateToEditItemPeminjaman: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailPeminjamanViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val uiStatePeminjaman = viewModel.uiStatePeminjaman.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        topBar = {
            PeminjamanTopAppBar(
                title = DetailDestinationPeminjaman.titleRes,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToEditItemPeminjaman(uiStatePeminjaman.value.addEventPeminjaman.id) },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = ""
                )
            }
        }

    ) {innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg15),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        ItemDetailsBodyPeminjaman(
            detailUIStatePeminjaman = uiStatePeminjaman.value,
            onDeletePeminjaman = {
                coroutineScope.launch {
                    viewModel.deletePeminjaman()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        )

    }
}
@Composable
private fun ItemDetailsBodyPeminjaman(
    detailUIStatePeminjaman: DetailUIStatePeminjaman,
    onDeletePeminjaman: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        var deleteConfirmationRequiredPeminjaman by rememberSaveable { mutableStateOf(false) }
        ItemDetailsPeminjaman(
            peminjaman = detailUIStatePeminjaman.addEventPeminjaman.toPeminjaman(),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(
            onClick = { deleteConfirmationRequiredPeminjaman = true },
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Delete", color = Color.Black)
        }

        if(deleteConfirmationRequiredPeminjaman){
            DeleteConfirmationDialogPeminjaman(
                onDeleteConfirmPeminjaman = {
                    deleteConfirmationRequiredPeminjaman = false
                    onDeletePeminjaman()},
                onDeletecancelmPeminjaman = { deleteConfirmationRequiredPeminjaman = false },
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}
@Composable
fun ItemDetailsPeminjaman(
    peminjaman: Peminjaman,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ItemDetailsRowPeminjaman(
                labelResIDPeminjaman = "Anggota",
                itemDetailPeminjaman = peminjaman.anggota,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowPeminjaman(
                labelResIDPeminjaman = "Buku",
                itemDetailPeminjaman = peminjaman.buku,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowPeminjaman(
                labelResIDPeminjaman = "Tanggal Kembali",
                itemDetailPeminjaman = peminjaman.tanggalbalik,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowPeminjaman(
                labelResIDPeminjaman = "Tanggal Peminjaman",
                itemDetailPeminjaman = peminjaman.tanggalpinjam,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
        }
    }
}

@Composable
private fun ItemDetailsRowPeminjaman(
    labelResIDPeminjaman: String,
    itemDetailPeminjaman: String,
    modifier: Modifier =Modifier
){
    Row (modifier = modifier){
        Text(text = labelResIDPeminjaman, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetailPeminjaman, fontWeight = FontWeight.Bold)

    }
}

@Composable
private fun DeleteConfirmationDialogPeminjaman(
    onDeleteConfirmPeminjaman: () -> Unit,
    onDeletecancelmPeminjaman: () -> Unit,
    modifier: Modifier = Modifier
){
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text("Are you sure") },
        text = { Text("Delete") },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeletecancelmPeminjaman) {
                Text(text = "No")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirmPeminjaman) {
                Text(text = "Yes")
            }
        }
    )
}