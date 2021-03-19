package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.ButtonGroupAddress
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun SimpleCounterScreen(navController: NavHostController, model: CounterViewModel, idx: Int) {
    AppScreenTemplate(
        title = model.simpleCounterModelList[idx].title,
        iconOnClick = { navController.popBackStack() }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            SingleCounter(
                countStringLive = model.simpleCounterModelList[idx].countStringLive,
                buttonEventHandler = model.simpleCounterModelList[idx]::buttonEventHandler,
                buttonGroupAddress = ButtonGroupAddress("SimpleCounter")
            )
        }
    }
}