package com.jvmlab.android.jetcounter.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun SimpleCounterSetupScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = model.simpleCounterSetupModel.title,
        iconOnClick = { navController.popBackStack() }
    ) {

    }
}

