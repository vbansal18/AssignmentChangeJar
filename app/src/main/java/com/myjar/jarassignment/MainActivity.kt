package com.myjar.jarassignment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.myjar.jarassignment.ui.vm.JarViewModel
import com.myjar.jarassignment.ui.composables.AppNavigation
import com.myjar.jarassignment.ui.theme.JarAssignmentTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<JarViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Log.d("TAG1", viewModel.listStringData.toString())

            LaunchedEffect(viewModel.listStringData) {
                viewModel.fetchData()
            }
            Log.d("TAG2", viewModel.listStringData.toString())
            JarAssignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel,
                    )
                }
            }
        }
    }
}