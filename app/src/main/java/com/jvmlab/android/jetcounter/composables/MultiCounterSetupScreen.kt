package com.jvmlab.android.jetcounter.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel


@ExperimentalComposeUiApi
@Composable
fun MultiCounterSetupScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = stringResource(model.multiCounterSetupModel.titleKey),
        iconOnClick = { navController.popBackStack() }
    ) {
        MultiCounterSetup(model.multiCounterSetupModel, navController::popBackStack )
    }
}

