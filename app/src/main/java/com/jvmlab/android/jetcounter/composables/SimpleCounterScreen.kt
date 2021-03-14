package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.ButtonGroupAddress
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun SimpleCounterScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreen(
        title = model.simpleCounterModel.title,
        iconOnClick = { navController.popBackStack() },
        icon = Icons.Filled.ArrowBack) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            SingleCounter(
                countStringLive = model.simpleCounterModel.countStringLive,
                buttonEventHandler = model.simpleCounterModel::buttonEventHandler,
                buttonGroupAddress = ButtonGroupAddress("SimpleCounter")
            )
        }
    }
}