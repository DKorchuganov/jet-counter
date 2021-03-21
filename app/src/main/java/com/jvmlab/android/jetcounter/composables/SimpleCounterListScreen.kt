package com.jvmlab.android.jetcounter.composables

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun SimpleCounterListScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = "Simple Counters",
        iconOnClick = { navController.popBackStack() },
        floatingActionButton = {
            FloatingActionButton(onClick = {  navController.navigate("SimpleCounterSetup") }) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) {
        SimpleCounterList(model.simpleCounterModelList) {
            navController.navigate("SimpleCounter/$it")
        }
    }
}