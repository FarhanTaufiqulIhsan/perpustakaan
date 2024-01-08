package com.example.perpustakaan.ui.anggota.addAnggota

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.perpustakaan.data.AnggotaRepository
import com.example.perpustakaan.ui.AddEventAnggota
import com.example.perpustakaan.ui.AddUIStateAnggota
import com.example.perpustakaan.ui.toAnggota

class AddAnggotaViewModel(private val anggotaRepository: AnggotaRepository) : ViewModel() {
    var addUIStateAnggota by mutableStateOf(AddUIStateAnggota())
        private set

    fun updateAddUIStateAnggota(addEventAnggota: AddEventAnggota) {
        addUIStateAnggota = AddUIStateAnggota(addEventAnggota = addEventAnggota)
    }

    suspend fun addAnggota() {
        anggotaRepository.save(addUIStateAnggota.addEventAnggota.toAnggota())
    }
}