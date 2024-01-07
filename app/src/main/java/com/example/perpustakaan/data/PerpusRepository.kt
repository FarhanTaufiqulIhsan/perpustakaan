package com.example.perpustakaan.data

import android.content.ContentValues
import android.util.Log
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
        return try {
            val documentReference = firestore.collection("Anggota")
                .add(anggota)
                .await()
            firestore.collection("Anggota").document(documentReference.id)
                .set(anggota.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(anggota: Anggota) {
        firestore.collection("Anggota").document(anggota.id).set(anggota).await()
    }

    override suspend fun delete(anggotaId: String) {
        firestore.collection("Anggota").document(anggotaId).delete().await()
    }

    override fun getAnggotaById(anggotaId: String): Flow<Anggota> {
        return flow {
            val snapshot = firestore.collection("Anggota").document(anggotaId).get().await()
            val anggota = snapshot.toObject(Anggota::class.java)
            emit(anggota!!)
        }.flowOn(Dispatchers.IO)
    }

}

interface BukuRepository {

}