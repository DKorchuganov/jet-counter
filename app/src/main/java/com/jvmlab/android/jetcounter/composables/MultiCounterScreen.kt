package com.jvmlab.android.jetcounter.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun MultiCounterScreen(navController: NavHostController, model: CounterViewModel, idx: Int) {
    val counterModelList = model.multiCounterSetupModel.counterModelList

    AppScreenTemplate(
        title = counterModelList[idx].title,
        iconOnClick = { navController.popBackStack() }
    ) {
        SingleCounterList(
            countStringLiveList = counterModelList[idx].countStringLiveList,
            onIncrement = counterModelList[idx]::onIncrement,
            onDecrement = counterModelList[idx]::onDecrement,
            counterNames = counterModelList[idx].names
        )
    }
}