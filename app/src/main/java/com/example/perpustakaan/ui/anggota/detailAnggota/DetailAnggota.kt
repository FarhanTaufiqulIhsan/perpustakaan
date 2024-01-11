package com.example.perpustakaan.ui.anggota.detailAnggota

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
import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.AnggotaTopAppBar
import com.example.perpustakaan.ui.DetailUIStateAnggota
import com.example.perpustakaan.ui.PenyediaViewModel
import com.example.perpustakaan.ui.toAnggota
import kotlinx.coroutines.launch

object DetailDestinationAnggota : DestinasiNavigasi {
    override val route = "item_details_anggota"
    override val titleRes = "Detail Anggota"
    const val anggotaId = "itemAnggotaId"
    val routeWithArgs = "$route/{$anggotaId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenAnggota(
    navigateToEditItemAnggota: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailAnggotaViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiStateAnggota = viewModel.uiStateAnggota.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            AnggotaTopAppBar(
                title = DetailDestinationAnggota.titleRes,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToEditItemAnggota(uiStateAnggota.value.addEventAnggota.id) },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "",
                )
            }
        }
    ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg14),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        ItemDetailsBodyAnggota(
            detailUIStateAnggota = uiStateAnggota.value,
            onDeleteAnggota = {
                coroutineScope.launch {
                    viewModel.deleteAnggota()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
        )
    }
}

@Composable
private fun ItemDetailsBodyAnggota(
    detailUIStateAnggota: DetailUIStateAnggota,
    onDeleteAnggota: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        var deleteConfirmationRequiredAnggota by rememberSaveable { mutableStateOf(false) }
        ItemDetailsAnggota(
            anggota = detailUIStateAnggota.addEventAnggota.toAnggota(),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(
            onClick = { deleteConfirmationRequiredAnggota = true },
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Delete", color = Color.Black)
        }

        if (deleteConfirmationRequiredAnggota) {
            DeleteConfirmationDialogAnggota(
                onDeleteConfirmAnggota = {
                    deleteConfirmationRequiredAnggota = false
                    onDeleteAnggota()
                },
                onDeleteCancelAnggota = { deleteConfirmationRequiredAnggota = false },
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Composable
fun ItemDetailsAnggota(
    anggota: Anggota,
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
            ItemDetailsRowAnggota(
                labelResIDAnggota = "Nama",
                itemDetailAnggota = anggota.nama,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowAnggota(
                labelResIDAnggota = "Alamat",
                itemDetailAnggota = anggota.alamat,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowAnggota(
                labelResIDAnggota = "Jenis Kelamin",
                itemDetailAnggota = anggota.jk,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowAnggota(
                labelResIDAnggota = "Nomor Telepon",
                itemDetailAnggota = anggota.nohp,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
        }
    }
}

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
private fun DeleteConfirmationDialogAnggota(
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