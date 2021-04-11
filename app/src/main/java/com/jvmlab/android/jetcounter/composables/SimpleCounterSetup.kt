package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.models.SimpleCounterSetupModel


@ExperimentalComposeUiApi
@Composable
fun SimpleCounterSetup(model: SimpleCounterSetupModel, navigateToCounter: () -> Unit) {
    val counterTitle: String by model.counterTitleLive.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleTextField(
            modifier = Modifier.fillMaxWidth(),
            value = counterTitle,
            onValueChange = { model.onCounterTitleChange(it) },
            labelText = "Counter title"
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                model.onDone()
                navigateToCounter()
            }
        ) {
            Text("Done", style = MaterialTheme.typography.h5)
        }
    }
}