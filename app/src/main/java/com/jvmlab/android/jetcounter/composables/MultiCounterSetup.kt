package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
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
    val numberOfCounters: Int by model.numberOfCountersLive.observeAsState(1)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                value = counterTitle,
                onValueChange = { model.onCounterTitleChange(it) },
                label = { Text("Counter title") }
            )
            Divider(modifier = Modifier.padding(bottom = 16.dp))

            for (idx in 0 until numberOfCounters) {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                    value = model.counterNameLiveList[idx].observeAsState("").value,
                    onValueChange = { model.onCounterNameChange(it, idx) },
                    label = { Text("Counter name") }
                )
            }

            IconButton(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.End),
                onClick = { model.onCounterNameAdd() }
            ) {
                Icon(Icons.Default.AddBox, null)
            }

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
}