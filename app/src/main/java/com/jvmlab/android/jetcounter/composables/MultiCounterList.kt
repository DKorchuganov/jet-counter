package com.jvmlab.android.jetcounter.composables


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jvmlab.android.jetcounter.models.MultiCounterModel
import com.jvmlab.android.jetcounter.models.SimpleCounterModel


@Composable
fun MultiCounterList(
    multiCounterModelList: List<MultiCounterModel>,
    navigateByIndex: (Int) -> Unit
) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (index in 0..multiCounterModelList.lastIndex) {
            MultiCounterCard(multiCounterModelList[index]) {
                navigateByIndex(index)
            }
        }
    }
}
