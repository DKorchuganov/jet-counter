package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData


@Composable
fun SingleCounter(
    countStringLive: LiveData<String>,
    buttonEventHandler: (String) -> Unit,
    name: String
) {
    val countString: String by countStringLive.observeAsState("")
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Column (modifier = Modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = name,
                fontSize = 32.sp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        buttonEventHandler("decrementButton")
                    }
                ) {
                    Text(text = "-", fontSize = 48.sp)
                }
                Text(text = countString, fontSize = 60.sp)
                Button(
                    onClick = {
                        buttonEventHandler("incrementButton")
                    }
                ) {
                    Text(text = "+", fontSize = 48.sp)
                }
            }
        }
    }
}