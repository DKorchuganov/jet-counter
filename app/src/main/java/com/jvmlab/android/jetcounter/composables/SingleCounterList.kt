package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import com.jvmlab.android.jetcounter.ButtonAddress
import com.jvmlab.android.jetcounter.ButtonGroupAddress


@Composable
fun SingleCounterList(
    countStringLiveList: List<LiveData<String>>,
    buttonEventHandler: (ButtonAddress) -> Unit,
    screen: String,
    counterNames: List<String>
) {
    Column {
        for (index in 0..counterNames.lastIndex) {
            SingleCounter(
                countStringLive = countStringLiveList[index],
                buttonEventHandler = buttonEventHandler,
                buttonGroupAddress = ButtonGroupAddress(screen, index),
                name = counterNames[index]
            )
        }
    }
}
