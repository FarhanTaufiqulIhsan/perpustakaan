package com.example.perpustakaan.ui.buku.editBuku

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perpustakaan.data.BukuRepository
import com.example.perpustakaan.ui.AddUIStateBuku
import com.example.perpustakaan.ui.toUIStateBuku
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditBukuViewModel (
    savedStateHandle: SavedStateHandle,
    private val repository: BukuRepository
) : ViewModel(){
    var bukuUIState by mutableStateOf(AddUIStateBuku())
        private set

    private val bukuId: String = checkNotNull(savedStateHandle[EditDestinationBuku.bukuId])

    init {
        viewModelScope.launch {
            bukuUIState =
                repository.getBukuById(bukuId)
                    .filterNotNull()
                    .first()
                    .toUIStateBuku()
        }
    }
}