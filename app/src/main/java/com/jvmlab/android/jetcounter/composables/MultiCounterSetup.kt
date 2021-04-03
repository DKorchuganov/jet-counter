package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.models.MultiCounterSetupModel


@Composable
fun MultiCounterSetup(model: MultiCounterSetupModel, navigateToCounter: () -> Unit) {
    val counterTitle: String by model.counterTitleLive.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.padding(8.dp),
            value = counterTitle,
            onValueChange = { model.textFieldEventHandler(it) },
            label = { Text("Counter title") }
        )
        Divider()
        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                model.buttonEventHandler()
                navigateToCounter()
            }
        ) {
            Text("Create", style = MaterialTheme.typography.h5)
        }
    }
}