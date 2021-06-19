package com.jvmlab.android.jetcounter.composables

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.jvmlab.android.jetcounter.CounterViewModel
import com.jvmlab.android.jetcounter.R


@Composable
fun SimpleCounterListScreen(navController: NavHostController, model: CounterViewModel) {
    AppScreenTemplate(
        title = stringResource(R.string.simple_counters),
        iconOnClick = { navController.popBackStack() },
        floatingActionButton = {
            FloatingActionButton(onClick = {  navController.navigate("SimpleCounterSetup") }) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) {
        SimpleCounterList(model.simpleCounterSetupModel.counterModelList) {
            navController.navigate("SimpleCounter/$it")
        }
    }
}