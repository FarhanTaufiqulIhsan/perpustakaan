package com.example.perpustakaan.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val anggotaRepository: AnggotaRepository
}

class PerpusContainer : AppContainer {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val anggotaRepository: AnggotaRepository by lazy {
        AnggotaRepositoryImpl(firestore)
    }
}