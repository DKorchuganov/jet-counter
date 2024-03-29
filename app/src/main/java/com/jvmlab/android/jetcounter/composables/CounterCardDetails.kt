package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jvmlab.android.jetcounter.R

@Composable
fun CounterCardDetails(id: String, onDelete: () -> Unit) {
    var expanded by remember(id) { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    Divider(modifier = Modifier.padding(horizontal = 8.dp))
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
                onClick = { showDeleteDialog = true }
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

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = {
                Text(text = stringResource(R.string.confirm_delete))
            },
            text = {
                Text(text = stringResource(R.string.confirm_delete_counter))
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDeleteDialog = false
                        onDelete()
                    }
                ) {
                    Text(stringResource(R.string.confirm_delete_button))
                }
            },
            dismissButton = {
                Button(onClick = { showDeleteDialog = false }) {
                    Text(stringResource(R.string.cancel_button))
                }
            },
        )
    }
}