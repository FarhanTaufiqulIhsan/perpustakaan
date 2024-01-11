package com.example.perpustakaan.ui.halaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.perpustakaan.R
import com.example.perpustakaan.navigation.DestinasiNavigasi

object DestinasiUtama : DestinasiNavigasi {
    override val route = "Item"
    override val titleRes = "Pilih"
}

@Composable
fun HalamanUtama(
    onBukuClick: () -> Unit,
    onAnggotaClick: () -> Unit,
    onPeminjamanClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.perpus),
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 150.dp, top = 100.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onBukuClick,
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.brown)),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text("BUKU")
            }

            Button(
                onClick = onAnggotaClick,
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.brown)),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text("ANGGOTA")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onPeminjamanClick,
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.brown)),
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Text("PEMINJAMAN")
        }
    }
}