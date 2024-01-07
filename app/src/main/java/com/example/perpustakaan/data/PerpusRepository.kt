package com.example.perpustakaan.data

import com.example.perpustakaan.model.Anggota
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreKtxRegistrar
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

interface AnggotaRepository {
    fun getAll(): Flow<List<Anggota>>
    suspend fun save(anggota: Anggota): String
    suspend fun update(anggota: Anggota)
    suspend fun delete(anggotaId: String)
    fun getAnggotaById(anggotaId: String): Flow<Anggota>
}

class AnggotaRepositoryImpl(private val firestore: FirebaseFirestore) : AnggotaRepository {
    override fun getAll(): Flow<List<Anggota>> = flow {
        val snapshot = firestore.collection("Anggota")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val anggota = snapshot.toObjects(Anggota::class.java)
        emit(anggota)
    }.flowOn(Dispatchers.IO)

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