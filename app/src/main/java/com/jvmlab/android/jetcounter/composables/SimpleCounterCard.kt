package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.models.SimpleCounterModel


@Composable
fun SimpleCounterCard(model: SimpleCounterModel, onDelete: () -> Unit, onClick: () -> Unit) {
    val countString: String by model.countStringLive.observeAsState("")
    Card(
        modifier = Modifier.padding(bottom = 16.dp),
        elevation = 4.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable(onClick = onClick),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = model.title, style = MaterialTheme.typography.h5)
                Text(text = countString, style = MaterialTheme.typography.h5)
            }

            CounterCardDetails(model.id, onDelete)
        }
    }
}