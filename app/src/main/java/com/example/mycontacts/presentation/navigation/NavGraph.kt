package com.example.mycontacts.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycontacts.presentation.ContactViewModel
import com.example.mycontacts.presentation.screens.AddEditScreen
import com.example.mycontacts.presentation.screens.HomeScreen

@Composable
fun NavGraph(navHostController: NavHostController, viewModel: ContactViewModel = hiltViewModel()){

    val state by viewModel.state.collectAsState()
    NavHost(navController = navHostController, startDestination = Routes.Home.route ){

        composable(Routes.AddEdit.route){
            AddEditScreen(navHostController = navHostController,
                state = viewModel.state.collectAsState().value,
                onEvent = {viewModel.saveContact()})
        }

        composable(Routes.Home.route){
            HomeScreen(navHostController = navHostController,
                state = state,
                viewmodel = viewModel)
        }


    }

}