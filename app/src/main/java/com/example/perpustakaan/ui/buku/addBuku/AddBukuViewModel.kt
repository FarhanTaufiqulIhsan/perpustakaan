package com.example.perpustakaan.ui.buku.addBuku

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.BukuRepository
import com.example.perpustakaan.ui.AddEventBuku
import com.example.perpustakaan.ui.AddUIStateBuku
import com.example.perpustakaan.ui.toBuku

class AddBukuViewModel(private val bukuRepository: BukuRepository) : ViewModel() {
    var addUIStateBuku by mutableStateOf(AddUIStateBuku())
        private set

    fun updateAddUIStateBuku(addEventBuku: AddEventBuku) {
        addUIStateBuku = AddUIStateBuku(addEventBuku = addEventBuku)
    }

    suspend fun addBuku() {
        bukuRepository.save(addUIStateBuku.addEventBuku.toBuku())
    }
}