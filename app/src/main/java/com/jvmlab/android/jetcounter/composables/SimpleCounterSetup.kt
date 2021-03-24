package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jvmlab.android.jetcounter.models.SimpleCounterSetupModel


@Composable
fun SimpleCounterSetup(model: SimpleCounterSetupModel, navigateToCounter: () -> Unit) {
    val counterName: String by model.counterNameLive.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = counterName,
            onValueChange = { model.textFieldEventHandler(it) },
            label = { Text("Counter name") }
        )
        Button(
            onClick = {
                model.buttonEventHandler()
                navigateToCounter()
            }
        ) {
            Text("Create", style = MaterialTheme.typography.h5)
        }
    }
}