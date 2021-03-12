package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
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
