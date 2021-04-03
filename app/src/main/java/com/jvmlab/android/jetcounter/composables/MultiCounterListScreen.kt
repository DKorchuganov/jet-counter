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
fun MultiCounterListScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = "Multi Counters",
        iconOnClick = { navController.popBackStack() },
        floatingActionButton = {
            FloatingActionButton(onClick = {  navController.navigate("MultiCounterSetup") }) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) {
        MultiCounterList(model.multiCounterSetupModel.counterModelList) {
            navController.navigate("MultiCounter/$it")
        }
    }
}