package com.jvmlab.android.jetcounter.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun MultiCounterSetupScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = model.multiCounterSetupModel.title,
        iconOnClick = { navController.popBackStack() }
    ) {
        MultiCounterSetup(model.multiCounterSetupModel, navController::popBackStack )
    }
}

