package com.example.perpustakaan.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val anggotaRepository: AnggotaRepository
    val bukuRepository: BukuRepository
}

class PerpusContainer : AppContainer {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val anggotaRepository: AnggotaRepository by lazy {
        AnggotaRepositoryImpl(firestore)
    }

    override val bukuRepository: BukuRepository by lazy {
        BukuRepositoryImpl(firestore)
    }
}