package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel


@Composable
fun SimpleCounterScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreen(
        title = "Simple Counter",
        iconOnClick = { navController.popBackStack() },
        icon = Icons.Filled.ArrowBack) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            SingleCounter(
                model.countStringLive,
                model::buttonEventHandler,
                "SimpleCounter"
            )
        }
    }
}