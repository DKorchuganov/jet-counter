package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun SimpleCounterScreen(navController: NavHostController, model: CounterViewModel, idx: Int) {
    val simpleCounterModel = model.simpleCounterSetupModel.counterModelList[idx]

    AppScreenTemplate(
        title = simpleCounterModel.title,
        iconOnClick = { navController.popBackStack() }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            SingleCounter(
                countStringLive = simpleCounterModel.countStringLive,
                onIncrement = simpleCounterModel::onIncrement,
                onDecrement = simpleCounterModel::onDecrement,
            )
        }
    }
}