package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun SimpleCounterCard(model: SimpleCounterModel, onClick: () -> Unit) {
    val countString: String by model.countStringLive.observeAsState("")
    Card(
        modifier =
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = model.title, style = MaterialTheme.typography.h5)
            Text(text = countString, style = MaterialTheme.typography.h5)
        }

    }
}