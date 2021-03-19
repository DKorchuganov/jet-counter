package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jvmlab.android.jetcounter.models.SimpleCounterModel


@Composable
fun SimpleCounterList(
    simpleCounterModelList: List<SimpleCounterModel>,
    navigateByIndex: (Int) -> Unit
) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (index in 0..simpleCounterModelList.lastIndex) {
            SimpleCounterCard(simpleCounterModelList[index]) {
                navigateByIndex(index)
            }
        }
    }
}
