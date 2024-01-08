package com.example.perpustakaan.ui.buku

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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
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
import com.example.perpustakaan.model.Buku
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.example.perpustakaan.ui.BukuTopAppBar
import com.example.perpustakaan.ui.PenyediaViewModel

object DestinasiHome: DestinasiNavigasi{
    override val route = "home"
    override val titleRes = "Buku"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BukuScreen(
    navigateToItemEntryBuku: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: HalamanBukuViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold (
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BukuTopAppBar(
                title = "Buku",
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntryBuku,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
                ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ){ innerPadding ->
        val uiStateBuku by viewModel.homeUIStateBuku.collectAsState()
        BodyHomeBuku(
            itemBuku = uiStateBuku.listBuku,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onBukuClick = onDetailClick
        )
    }
}

@Composable
fun BodyHomeBuku(
    itemBuku: List<Buku>,
    modifier: Modifier = Modifier,
    onBukuClick: (String) -> Unit = {}
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemBuku.isEmpty()){
            Text(
                text = "Tidak ada data Buku",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListBuku(
                itemBuku = itemBuku,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onBukuClick(it.id) }
            )
        }
    }
}
@Composable
fun ListBuku(
    itemBuku: List<Buku>,
    modifier: Modifier = Modifier,
    onItemClick: (Buku) -> Unit
){
    LazyColumn(
        modifier = modifier
    ){
        this.items(itemBuku, key = {it.id}){buku ->
            DataBuku(
                buku = buku,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(buku) }
            )
        }
    }
}
@Composable
fun DataBuku(
    buku: Buku,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = buku.judul,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
                Text(
                    text = buku.pengarang,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = buku.kategori,
                    style = MaterialTheme.typography.titleLarge,
                    )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
                Text(
                    text = buku.tahunterbit,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}