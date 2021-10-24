package com.jvmlab.android.jetcounter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jvmlab.android.jetcounter.composables.*
import com.jvmlab.android.jetcounter.ui.theme.JetCounterTheme

@ExperimentalComposeUiApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetCounterTheme {
                val navController = rememberNavController()
                val model: CounterViewModel = viewModel(
                    factory = CounterViewModelFactory(
                        Repository(AppDatabase.getDB(applicationContext))
                    )
                )

                NavHost(navController, startDestination = "Main") {

                    composable(route = "Main") {
                        MainScreen(navController)
                    }

                    composable(route = "SimpleCounterList") {
                        SimpleCounterListScreen(navController, model)
                    }

                    composable(route = "SimpleCounterSetup") {
                        SimpleCounterSetupScreen(navController, model)
                    }

                    composable(
                        route = "SimpleCounter/{idx}",
                        arguments = listOf(navArgument("idx") { type = NavType.IntType })
                    ) {
                        val idx = it.arguments?.getInt("idx") ?: 0
                        SimpleCounterScreen(navController, model, idx)
                    }

                    composable(route = "MultiCounterList") {
                        MultiCounterListScreen(navController, model)
                    }

                    composable(route = "MultiCounterSetup") {
                        MultiCounterSetupScreen(navController, model)
                    }

                    composable(
                        route = "MultiCounter/{idx}",
                        arguments = listOf(navArgument("idx") { type = NavType.IntType })
                    ) {
                        val idx = it.arguments?.getInt("idx") ?: 0
                        MultiCounterScreen(navController, model, idx)
                    }
                }
            }
        }
    }
}