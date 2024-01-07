package com.example.perpustakaan.data

import com.example.perpustakaan.model.Anggota
import kotlinx.coroutines.flow.Flow

interface AnggotaRepository {
    fun getAll(): Flow<List<Anggota>>
    suspend fun save(anggota: Anggota): String
    suspend fun update(anggota: Anggota)
    suspend fun delete(anggotaId: String)
    fun getAnggotaById(anggotaId: String): Flow<Anggota>
}