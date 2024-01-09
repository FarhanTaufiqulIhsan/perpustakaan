package com.example.perpustakaan.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.perpustakaan.ui.anggota.addAnggota.AddAnggota
import com.example.perpustakaan.ui.anggota.addAnggota.DestinasiEntryAnggota
import com.example.perpustakaan.ui.anggota.detailAnggota.DetailDestinationAnggota
import com.example.perpustakaan.ui.anggota.detailAnggota.DetailScreenAnggota
import com.example.perpustakaan.ui.anggota.editAnggota.EditDestinationAnggota
import com.example.perpustakaan.ui.anggota.editAnggota.EditScreenAnggota
import com.example.perpustakaan.ui.anggota.homeAnggota.AnggotaScreen
import com.example.perpustakaan.ui.anggota.homeAnggota.DestinasiHomeAnggota
import com.example.perpustakaan.ui.buku.addBuku.AddBuku
import com.example.perpustakaan.ui.buku.addBuku.DestinasiEntryBuku
import com.example.perpustakaan.ui.buku.detailBuku.DetailDestinationBuku
import com.example.perpustakaan.ui.buku.detailBuku.DetailScreenBuku
import com.example.perpustakaan.ui.buku.editBuku.EditDestinationBuku
import com.example.perpustakaan.ui.buku.editBuku.EditScreenBuku
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
                onDetailClickAnggota = { itemIdAnggota ->
                    navController.navigate("${DetailDestinationAnggota.route}/$itemIdAnggota")
                    println("itemIdAnggota: $itemIdAnggota")
                }
            )
        }

        composable(
            route = DetailDestinationAnggota.routeWithArgs,
            arguments = listOf(navArgument(DetailDestinationAnggota.anggotaId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val anggotaId = backStackEntry.arguments?.getString(DetailDestinationAnggota.anggotaId)
            anggotaId?.let {
                DetailScreenAnggota(
                    navigateToEditItemAnggota = {
                        navController.navigate("${EditDestinationAnggota.route}/$anggotaId")
                        println("anggotaId: $anggotaId")
                    },
                    navigateBack = { navController.popBackStack() })
            }
        }

        composable(DestinasiEntryAnggota.route) {
            AddAnggota(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = EditDestinationAnggota.routeWithArgs,
            arguments = listOf(navArgument(EditDestinationAnggota.anggotaId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val anggotaId = backStackEntry.arguments?.getString(EditDestinationAnggota.anggotaId)
            anggotaId?.let {
                EditScreenAnggota(
                    navigateBackAnggota = { navController.popBackStack() },
                    onNavigateUpAnggota = { navController.navigateUp() })
            }
        }

        composable(
         route = EditDestinationBuku.routeWithArgs,
            arguments = listOf(navArgument(EditDestinationBuku.bukuId){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val bukuId = backStackEntry.arguments?.getString(EditDestinationBuku.bukuId)
            bukuId?.let{
                EditScreenBuku(
                    navigateBackBuku = { navController.popBackStack() },
                    onNavigateUpBuku = { navController.navigateUp() })
            }
        }

        composable(DestinasiHomeBuku.route) {
            BukuScreen(
                navigateToItemEntryBuku = {
                    navController.navigate(DestinasiEntryBuku.route)
                },
                onDetailClickBuku = { itemIdBuku ->
                    navController.navigate("${DetailDestinationBuku.route}/$itemIdBuku")
                    println("itemIdBuku: $itemIdBuku")
                }
            )
        }

        composable(
            route = DetailDestinationBuku.routeWithArgs,
            arguments = listOf(navArgument(DetailDestinationBuku.bukuId){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val bukuId = backStackEntry.arguments?.getString(DetailDestinationBuku.bukuId)
            bukuId?.let {
                DetailScreenBuku(navigateToEditItemBuku = {}, navigateBack = { /*TODO*/ })
            }

        }

        composable(DestinasiEntryBuku.route){
            AddBuku(navigateBack = { navController.popBackStack() })
        }
    }
}