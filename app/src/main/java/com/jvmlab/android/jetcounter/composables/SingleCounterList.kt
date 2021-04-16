package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData


@Composable
fun SingleCounterList(
    countStringLiveList: List<LiveData<String>>,
    onIncrement: (Int) -> Unit,
    onDecrement: (Int) -> Unit,
    counterNames: List<String>
) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (index in 0..counterNames.lastIndex) {
            SingleCounter(
                countStringLive = countStringLiveList[index],
                onIncrement = { onIncrement(index) },
                onDecrement = { onDecrement(index) },
                name = counterNames[index]
            )
        }
    }
}
