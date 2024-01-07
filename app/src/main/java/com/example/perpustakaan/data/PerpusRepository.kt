package com.example.perpustakaan.data

import com.example.perpustakaan.model.Anggota
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreKtxRegistrar
import kotlinx.coroutines.flow.Flow

interface AnggotaRepository {
    fun getAll(): Flow<List<Anggota>>
    suspend fun save(anggota: Anggota): String
    suspend fun update(anggota: Anggota)
    suspend fun delete(anggotaId: String)
    fun getAnggotaById(anggotaId: String): Flow<Anggota>
}

class AnggotaRepositoryImpl(private val firestore: FirebaseFirestore) : AnggotaRepository {
    override fun getAll(): Flow<List<Anggota>> {
        TODO("Not yet implemented")
    }

    override suspend fun save(anggota: Anggota): String {
        TODO("Not yet implemented")
    }

    override suspend fun update(anggota: Anggota) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(anggotaId: String) {
        TODO("Not yet implemented")
    }

    override fun getAnggotaById(anggotaId: String): Flow<Anggota> {
        TODO("Not yet implemented")
    }

}