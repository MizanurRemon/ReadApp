package com.readapp.readapp.navigations

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.readapp.readapp.screens.HomeScreen

enum class Route {
    HOME,

}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppNavigations(navController: NavHostController = rememberNavController()) {
    Scaffold { paddingValues->
        val context = LocalContext.current
        NavHost(navController = navController, startDestination = Route.HOME.name){
            composable(route = Route.HOME.name){
                HomeScreen()
            }
        }
    }
}