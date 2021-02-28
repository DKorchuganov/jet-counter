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
fun MultiCounterScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreen(
        title = "Multi Counter",
        iconOnClick = { navController.popBackStack() },
        icon = Icons.Filled.ArrowBack) {
        SingleCounter(
            model.countStringLive,
            model::buttonEventHandler,
            ButtonGroupAddress("MultiCounter")
        )
    }
}