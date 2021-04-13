package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.models.AbstractCounterSetupModel


@ExperimentalComposeUiApi
@Composable
fun CounterSetupTemplate(
    model: AbstractCounterSetupModel,
    navigateToCounter: () -> Unit,
    content: @Composable () -> Unit = {}
) {
    val counterTitle: String by model.counterTitleLive.observeAsState("")

    SingleTextField(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        value = counterTitle,
        onValueChange = { model.onCounterTitleChange(it) },
        labelText = "Counter title"
    )

    content()

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