package com.jvmlab.android.jetcounter.composables


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel

@Composable
fun MultiCounterScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreen(
        title = "Multi Counter",
        iconOnClick = { navController.popBackStack() },
        icon = Icons.Filled.ArrowBack) {
        SingleCounterList(
            countStringLiveList = model.multiCounterModel.countStringLiveList,
            buttonEventHandler = model::buttonEventHandler,
            screen = "MultiCounter",
            counterNames = model.multiCounterModel.counterNames
        )
    }
}