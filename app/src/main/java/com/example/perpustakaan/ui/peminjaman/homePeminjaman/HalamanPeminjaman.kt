package com.example.perpustakaan.ui.peminjaman.homePeminjaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.DateRange
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perpustakaan.R
import com.example.perpustakaan.model.Peminjaman
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.PeminjamanTopAppBar
import com.example.perpustakaan.ui.PenyediaViewModel

object DestinasiHomePeminjaman : DestinasiNavigasi {
    override val route = "home peminjaman"
    override val titleRes = "Peminjaman"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeminjamanScreen(
    navigateToItemEntryPeminjaman: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClickPeminjaman: (String) -> Unit = {},
    viewModel: HalamanPeminjamanViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PeminjamanTopAppBar(
                title = "Peminjaman",
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToItemEntryPeminjaman() },
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
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.backgroud1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            val uiStatePeminjaman by viewModel.homeUIStatePeminjaman.collectAsState()
            BodyHomePeminjaman(
                itemPeminjaman = uiStatePeminjaman.listPeminjaman,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                onPeminjamanClick = onDetailClickPeminjaman
            )
        }

    }
}

@Composable
fun BodyHomePeminjaman(
    itemPeminjaman: List<Peminjaman>,
    modifier: Modifier = Modifier,
    onPeminjamanClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemPeminjaman.isEmpty()) {
            Text(
                text = "Tidak ada data Peminjaman",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListPeminjaman(
                itemPeminjaman = itemPeminjaman,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onPeminjamanClick(it.id) }
            )
        }
    }
}

@Composable
fun ListPeminjaman(
    itemPeminjaman: List<Peminjaman>,
    modifier: Modifier = Modifier,
    onItemClick: (Peminjaman) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemPeminjaman, key = {it.id}) {peminjaman ->
            DataPeminjaman(
                peminjaman = peminjaman,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(peminjaman) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun DataPeminjaman(
    peminjaman: Peminjaman,
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
                    text = peminjaman.buku,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.DateRange,
                    tint = Color.Red,
                    contentDescription = null,
                )
                Text(
                    text = peminjaman.tanggalbalik,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = peminjaman.anggota,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.DateRange,
                    tint = Color.Green,
                    contentDescription = null,
                )
                Text(
                    text = peminjaman.tanggalpinjam,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}