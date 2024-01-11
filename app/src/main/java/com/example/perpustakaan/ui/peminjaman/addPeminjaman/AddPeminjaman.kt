package com.example.perpustakaan.ui.peminjaman.addPeminjaman

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.perpustakaan.ui.AddEventPeminjaman
import org.threeten.bp.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputPeminjaman(
    addEventPeminjaman: AddEventPeminjaman,
    modifier: Modifier = Modifier,
    onValueChangePeminjaman: (AddEventPeminjaman) -> Unit = {},
    enabled: Boolean = true
){
    var tanggalPinjam by remember { mutableStateOf(addEventPeminjaman.tanggalPinjam) }
    var tanggalKembali by remember { mutableStateOf(addEventPeminjaman.tanggalKembali) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = addEventPeminjaman.anggota,
            onValueChange = { onValueChangePeminjaman(addEventPeminjaman.copy(anggota = it)) },
            label = { Text(text = "Anggota") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = addEventPeminjaman.buku,
            onValueChange = { onValueChangePeminjaman(addEventPeminjaman.copy(buku = it)) },
            label = { Text(text = "Buku") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        // DatePicker for tanggalPinjam
        DatePicker(
            selectedDate = tanggalPinjam,
            onDateChange = {
                tanggalPinjam = it
                onValueChangePeminjaman(addEventPeminjaman.copy(tanggalPinjam = it))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )

        // DatePicker for tanggalKembali
        DatePicker(
            selectedDate = tanggalKembali,
            onDateChange = {
                tanggalKembali = it
                onValueChangePeminjaman(addEventPeminjaman.copy(tanggalKembali = it))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(
    selectedDate: LocalDate,
    onDateChange: (LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {

}
