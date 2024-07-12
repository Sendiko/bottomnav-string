package com.sendiko.bottomnavbar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sendiko.bottomnavbar.navigation.AboutScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigate: (route: Any) -> Unit
) {
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Column {
                        Text(text = "Welcome, ", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Sendiko", fontSize = 20.sp)
                    }
                },
                actions = {
                    IconButton(onClick = { onNavigate(AboutScreen) }) {
                        Icon(imageVector = Icons.Rounded.Info, contentDescription = "about app")
                    }
                }
            )
        }
    ) {

    }
}