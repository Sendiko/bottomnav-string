package com.sendiko.bottomnavbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sendiko.bottomnavbar.navigation.RootNavGraph
import com.sendiko.bottomnavbar.ui.theme.BottomnavbarTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomnavbarTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        RootNavGraph(
                            navController = rememberNavController()
                        )
                    }
                )
            }
        }
    }
}