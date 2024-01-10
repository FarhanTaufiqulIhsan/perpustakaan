package com.example.perpustakaan.ui.peminjaman.addPeminjaman

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.PeminjamanRepository
import com.example.perpustakaan.ui.AddEventPeminjaman
import com.example.perpustakaan.ui.AddUIStatePeminjaman
import com.example.perpustakaan.ui.toPeminjaman

class AddPeminjamanViewModel (private val peminjamanRepository: PeminjamanRepository) : ViewModel(){
    var addUIStatePeminjaman by mutableStateOf(AddUIStatePeminjaman())
        private set

    fun updateAddUIStatePeminjaman(addEventPeminjaman: AddEventPeminjaman){
        addUIStatePeminjaman = AddUIStatePeminjaman(addEventPeminjaman = addEventPeminjaman)
    }

    suspend fun addPeminjaman(){
        peminjamanRepository.save(addUIStatePeminjaman.addEventPeminjaman.toPeminjaman())
    }
}