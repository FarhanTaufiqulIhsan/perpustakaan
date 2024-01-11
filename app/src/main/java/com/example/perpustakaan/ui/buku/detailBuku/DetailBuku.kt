package com.example.perpustakaan.ui.buku.detailBuku

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
import com.example.perpustakaan.model.Buku
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.BukuTopAppBar
import com.example.perpustakaan.ui.DetailUIStateBuku
import com.example.perpustakaan.ui.PenyediaViewModel
import com.example.perpustakaan.ui.toBuku
import kotlinx.coroutines.launch

object DetailDestinationBuku : DestinasiNavigasi{
    override val route = "item_details_buku"
    override val titleRes = "Detail Buku"
    const val bukuId = "itemBukuId"
    val routeWithArgs = "$route/{$bukuId}"

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenBuku(
    navigateToEditItemBuku: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailBukuViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val uiStateBuku = viewModel.uiStateBuku.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        topBar = {
            BukuTopAppBar(
                title = DetailDestinationBuku.titleRes,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToEditItemBuku(uiStateBuku.value.addEventBuku.id) },
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
            painter = painterResource(id = R.drawable.bg8),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        ItemDetailsBodyBuku(
            detailUIStateBuku = uiStateBuku.value,
            onDeleteBuku = {
                coroutineScope.launch {
                    viewModel.deleteBuku()
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
private fun ItemDetailsBodyBuku(
    detailUIStateBuku: DetailUIStateBuku,
    onDeleteBuku: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        var deleteConfirmationRequiredBuku by rememberSaveable { mutableStateOf(false)}
        ItemDetailsBuku(
            buku = detailUIStateBuku.addEventBuku.toBuku(),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(
            onClick = { deleteConfirmationRequiredBuku = true },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
            ) {
                Text("Delete", color = Color.Black)
        }

        if(deleteConfirmationRequiredBuku){
            DeleteConfirmationDialogBuku(
                onDeleteConfirmBuku = {
                    deleteConfirmationRequiredBuku = false
                    onDeleteBuku()},
                onDeletecancelmBuku = { deleteConfirmationRequiredBuku = false },
                modifier = Modifier.padding(12.dp)
                )
        }
    }
}

@Composable
fun ItemDetailsBuku(
    buku: Buku,
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
                itemDetailBuku = buku.penerbit,
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