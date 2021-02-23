package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun AppScreen(
    title: String,
    iconOnClick: () -> Unit,
    icon: ImageVector,
    content: @Composable () -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = iconOnClick) {
                        Icon(icon, null)
                    }
                }
            )
            content()
        }
    }
}