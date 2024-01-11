package com.example.perpustakaan.data

import android.content.ContentValues
import android.util.Log
import com.example.perpustakaan.model.Anggota
import com.example.perpustakaan.model.Buku
import com.example.perpustakaan.model.Peminjaman
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
    fun getAll(): Flow<List<Buku>>
    suspend fun save(buku: Buku): String
    suspend fun update(buku: Buku)
    suspend fun delete(bukuId: String)
    fun getBukuById(bukuId: String): Flow<Buku>
}

class BukuRepositoryImpl(private val firestore: FirebaseFirestore) : BukuRepository{
    override fun getAll(): Flow<List<Buku>> = flow {
        val snapshot = firestore.collection("Buku")
            .orderBy("judul", Query.Direction.ASCENDING)
            .get()
            .await()
        val buku = snapshot.toObjects(Buku::class.java)
        emit(buku)
    }.flowOn(Dispatchers.IO)

    override suspend fun save(buku: Buku): String {
        return try {
            val documentReference = firestore.collection("Buku")
                .add(buku)
                .await()
            firestore.collection("Buku").document(documentReference.id)
                .set(buku.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(buku: Buku) {
        firestore.collection("Buku").document(buku.id).set(buku).await()
    }

    override suspend fun delete(bukuId: String) {
        firestore.collection("Buku").document(bukuId).delete().await()
    }

    override fun getBukuById(bukuId: String): Flow<Buku> {
        return flow {
            val snapshot = firestore.collection("Buku").document(bukuId).get().await()
            val buku = snapshot.toObject(Buku::class.java)
            emit(buku!!)
        }.flowOn(Dispatchers.IO)
    }

}

interface PeminjamanRepository {
    fun getAll(): Flow<List<Peminjaman>>
    suspend fun save(peminjaman: Peminjaman): String
    suspend fun update(peminjaman: Peminjaman)
    suspend fun delete(peminjamanId: String)
    fun getPeminjamanById(peminjamanId: String): Flow<Peminjaman>
}

class PeminjamanRepositoryImpl(private val firestore: FirebaseFirestore) : PeminjamanRepository {
    override fun getAll(): Flow<List<Peminjaman>> = flow {
        val snapshot = firestore.collection("Peminjaman")
            .orderBy("anggota", Query.Direction.ASCENDING)
            .get()
            .await()
        val peminjaman = snapshot.toObjects(Peminjaman::class.java)
        emit(peminjaman)
    }.flowOn(Dispatchers.IO)

    override suspend fun save(peminjaman: Peminjaman): String {
        return try {
            val documentReference = firestore.collection("Peminjaman").add(peminjaman).await()
            firestore.collection("Peminjaman").document(documentReference.id)
                .set(peminjaman.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(peminjaman: Peminjaman) {
        firestore.collection("Peminjaman").document(peminjaman.id).set(peminjaman).await()
    }

    override suspend fun delete(peminjamanId: String) {
        firestore.collection("Peminjaman").document(peminjamanId).delete().await()
    }

    override fun getPeminjamanById(peminjamanId: String): Flow<Peminjaman> {
        return flow {
            val snapshot = firestore.collection("Peminjaman").document(peminjamanId).get().await()
            val peminjaman = snapshot.toObject(Peminjaman::class.java)
            emit(peminjaman!!)
        }.flowOn(Dispatchers.IO)
    }
}