package com.example.perpustakaan.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.perpustakaan.ui.anggota.addAnggota.AddAnggota
import com.example.perpustakaan.ui.anggota.addAnggota.DestinasiEntryAnggota
import com.example.perpustakaan.ui.anggota.homeAnggota.AnggotaScreen
import com.example.perpustakaan.ui.anggota.homeAnggota.DestinasiHomeAnggota
import com.example.perpustakaan.ui.buku.addBuku.AddBuku
import com.example.perpustakaan.ui.buku.addBuku.DestinasiEntryBuku
import com.example.perpustakaan.ui.buku.homeBuku.BukuScreen
import com.example.perpustakaan.ui.buku.homeBuku.DestinasiHomeBuku
import com.example.perpustakaan.ui.halaman.DestinasiHome
import com.example.perpustakaan.ui.halaman.DestinasiUtama
import com.example.perpustakaan.ui.halaman.HalamanHome
import com.example.perpustakaan.ui.halaman.HalamanUtama

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HalamanHome (
                onNextButtonClicked = {
                    navController.navigate(DestinasiUtama.route)
                },
            )
        }

        composable(DestinasiUtama.route) {
            HalamanUtama(
                onBukuClick = { navController.navigate(DestinasiHomeBuku.route) },
                onAnggotaClick = { navController.navigate(DestinasiHomeAnggota.route) }
            )
        }

        composable(DestinasiHomeAnggota.route) {
            AnggotaScreen(
                navigateToItemEntryAnggota = {
                    navController.navigate(DestinasiEntryAnggota.route)
                },
                onDetailClickAnggota = { }
            )
        }

        composable(DestinasiHomeBuku.route) {
            BukuScreen(
                navigateToItemEntryBuku = {
                    navController.navigate(DestinasiEntryBuku.route)
                },
                onDetailClickBuku = { }
            )
        }

        composable(DestinasiEntryAnggota.route) {
            AddAnggota(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(DestinasiEntryBuku.route){
            AddBuku(navigateBack = { navController.popBackStack() })
        }
    }
}