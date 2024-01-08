package com.example.perpustakaan.ui.anggota.homeAnggota

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.AnggotaTopAppBar
import com.example.perpustakaan.ui.PenyediaViewModel

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Anggota"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnggotaScreen(
    navigateToItemEntryAnggota: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: HalamanAnggotaViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AnggotaTopAppBar(
                title = "Anggota",
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntryAnggota,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
        ) { innerPadding ->
        val uiStateAnggota by viewModel.homeUIStateAnggota.collectAsState()
        BodyHomeAnggota(
            itemAnggota = uiStateAnggota.listAnggota,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onAnggotaClick = onDetailClick
        )
    }
}

@Composable
fun BodyHomeAnggota(
    itemAnggota: List<Anggota>,
    modifier: Modifier = Modifier,
    onAnggotaClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemAnggota.isEmpty()) {
            Text(
                text = "Tidak ada data Anggota",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListAnggota(
                itemAnggota = itemAnggota,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onAnggotaClick(it.id) }
            )
        }
    }
}

@Composable
fun ListAnggota(
    itemAnggota: List<Anggota>,
    modifier: Modifier = Modifier,
    onItemClick: (Anggota) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemAnggota, key = { it.id }) {anggota ->
            DataAnggota(
                anggota = anggota,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(anggota) }
            )
        }
    }
}

@Composable
fun DataAnggota(
    anggota: Anggota,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = anggota.nama,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text(
                    text = anggota.nohp,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = anggota.jk,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                )
                Text(
                    text = anggota.alamat,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}