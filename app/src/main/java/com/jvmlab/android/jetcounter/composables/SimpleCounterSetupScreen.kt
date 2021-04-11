package com.jvmlab.android.jetcounter.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel


@ExperimentalComposeUiApi
@Composable
fun SimpleCounterSetupScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = model.simpleCounterSetupModel.title,
        iconOnClick = { navController.popBackStack() }
    ) {
        SimpleCounterSetup(model.simpleCounterSetupModel, navController::popBackStack )
    }
}

