package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun AppScreenTemplate(
    title: String,
    iconOnClick: () -> Unit,
    icon: ImageVector = Icons.Filled.ArrowBack,
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(title) },
                    navigationIcon = {
                        IconButton(onClick = iconOnClick) {
                            Icon(icon, null)
                        }
                    }
                )
            },
            floatingActionButton = floatingActionButton,
            content = content
        )
    }
}