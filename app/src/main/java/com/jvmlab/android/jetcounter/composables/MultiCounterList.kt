package com.jvmlab.android.jetcounter.composables


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.jvmlab.android.jetcounter.models.MultiCounterModel


@Composable
fun MultiCounterList(
    multiCounterModelList: List<MultiCounterModel>,
    numberOfModelsLive: LiveData<Int>,
    onDelete: (Int) -> Unit,
    navigateByIndex: (Int) -> Unit
) {
    val numberOfModels: Int by numberOfModelsLive.observeAsState(0)

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.padding(16.dp)) {
            for (index in 0 until numberOfModels) {
                MultiCounterCard(
                    multiCounterModelList[index],
                    onDelete = { onDelete(index) }
                ) {
                    navigateByIndex(index)
                }
            }
        }
    }
}
