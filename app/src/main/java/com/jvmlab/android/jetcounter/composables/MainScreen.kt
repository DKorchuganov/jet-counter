package com.jvmlab.android.jetcounter.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.R


@Composable
fun MainScreen(navController: NavHostController) {
    AppScreenTemplate(
        title = stringResource(R.string.app_name),
        iconOnClick = { /*TODO*/ },
        icon = Icons.Filled.Menu) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Column(modifier = Modifier.padding(16.dp)) {
                CounterButton(
                    stringResource(R.string.simple_counter),
                    "SimpleCounterList",
                    navController
                )
                CounterButton(
                    stringResource(R.string.multi_counter),
                    "MultiCounterList",
                    navController
                )
            }
        }
    }
}

@Composable
fun CounterButton(title: String, route: String, navController: NavHostController) {
    OutlinedButton(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        onClick = {
            navController.navigate(route)
        }
    ) {
        Text(text = title, fontSize = 24.sp)
    }
}