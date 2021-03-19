package com.jvmlab.android.jetcounter.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun SimpleCounterListScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = "Simple Counters",
        iconOnClick = { navController.popBackStack() }
    ) {
        SimpleCounterList(model.simpleCounterModelList) {
            navController.navigate("SimpleCounter/$it")
        }
    }
}