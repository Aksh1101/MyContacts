package com.example.mycontacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.mycontacts.presentation.ContactViewModel
import com.example.mycontacts.presentation.navigation.NavGraph
import com.example.mycontacts.ui.theme.MyContactsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<ContactViewModel>()
            val navHostController = rememberNavController()
            MyContactsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    NavGraph(
                        navHostController = navHostController,
                        viewModel = viewModel,

                        )

                }
            }
        }
    }
}

