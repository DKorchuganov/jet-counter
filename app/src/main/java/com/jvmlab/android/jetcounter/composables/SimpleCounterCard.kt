package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.R
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
            Divider(modifier = Modifier.padding(horizontal = 8.dp))

            var expanded by remember { mutableStateOf(false) }
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            expanded = !expanded
                        }
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (expanded) {
                    Text(text = stringResource(R.string.hide_details))
                    Icon(Icons.Outlined.ExpandLess, null)
                } else {
                    Text(text = stringResource(R.string.show_details))
                    Icon(Icons.Outlined.ExpandMore, null)
                }

            }
            if (expanded) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(
                        onClick = onDelete
                    ) {
                        Icon(Icons.Outlined.Delete, null)
                    }
                    IconButton(
                        onClick = { /*TODO()*/ }
                    ) {
                        Icon(Icons.Outlined.ContentCopy, null)
                    }
                    IconButton(
                        onClick = { /*TODO()*/ }
                    ) {
                        Icon(Icons.Outlined.Share, null)
                    }
                }
            }
        }
    }
}