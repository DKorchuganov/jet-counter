package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate


@Composable
fun MainScreen(navController: NavHostController) {
    AppScreen(
        title = "Jet Counter",
        iconOnClick = { /*TODO*/ },
        icon = Icons.Filled.Menu) {
        OutlinedButton(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onClick = {
                navController.navigate("SimpleCounter")
            }
        ) {
            Text(text = "Simple Counter", fontSize = 24.sp)
        }
    }
}