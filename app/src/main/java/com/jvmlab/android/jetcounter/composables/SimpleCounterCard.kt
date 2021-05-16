package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.R
import com.jvmlab.android.jetcounter.models.SimpleCounterModel


@Composable
fun SimpleCounterCard(model: SimpleCounterModel, onClick: () -> Unit) {
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
            Divider(modifier = Modifier.padding(horizontal = 8.dp))
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable(onClick = { /*TODO*/ }),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.show_details))
                Icon(Icons.Outlined.ExpandMore, null)
            }
        }
    }
}