package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.models.MultiCounterSetupModel


@ExperimentalComposeUiApi
@Composable
fun MultiCounterSetup(model: MultiCounterSetupModel, navigateToCounter: () -> Unit) {
    val counterTitle: String by model.counterTitleLive.observeAsState("")
    val numberOfCounters: Int by model.numberOfCountersLive.observeAsState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            SingleTextField(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                value = counterTitle,
                onValueChange = { model.onCounterTitleChange(it) },
                labelText = "Counter title"
            )
            Divider(modifier = Modifier.padding(bottom = 16.dp))

            for (idx in 0 until numberOfCounters) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SingleTextField(
                        value = model.counterNameLiveList[idx].observeAsState("").value,
                        onValueChange = { model.onCounterNameChange(it, idx) },
                        labelText = "Counter name"
                    )
                    IconButton(
                        onClick = { model.onCounterNameDelete(idx) },
                        enabled = (numberOfCounters > 1)
                    ) {
                        Icon(Icons.Outlined.Delete, null, modifier = Modifier.size(48.dp) )
                    }
                }
            }

            IconButton(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.End),
                onClick = { model.onCounterNameAdd() }
            ) {
                Icon(Icons.Outlined.AddBox, null, modifier = Modifier.size(48.dp) )
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