package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jvmlab.android.jetcounter.models.SimpleCounterModel


@Composable
fun SimpleCounterCard(
    simpleCounterModel: SimpleCounterModel,
    onClick: () -> Unit
) {
    Card(
        modifier =
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = simpleCounterModel.title,
                fontSize = 24.sp
            )

        }

    }
}