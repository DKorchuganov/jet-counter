package com.jvmlab.android.jetcounter.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun MultiCounterScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = model.multiCounterModel.title,
        iconOnClick = { navController.popBackStack() }
    ) {
        SingleCounterList(
            countStringLiveList = model.multiCounterModel.countStringLiveList,
            buttonEventHandler = model.multiCounterModel::buttonEventHandler,
            screen = "MultiCounter",
            counterNames = model.multiCounterModel.names
        )
    }
}