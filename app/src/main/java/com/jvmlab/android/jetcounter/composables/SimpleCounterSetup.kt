package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.models.SimpleCounterSetupModel


@ExperimentalComposeUiApi
@Composable
fun SimpleCounterSetup(model: SimpleCounterSetupModel, navigateToCounter: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CounterSetupTemplate(model, navigateToCounter)
    }
}