package com.jvmlab.android.jetcounter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jvmlab.android.jetcounter.composables.MainScreen
import com.jvmlab.android.jetcounter.composables.SimpleCounterScreen
import com.jvmlab.android.jetcounter.ui.theme.JetCounterTheme

class MainActivity : AppCompatActivity() {
    private val model: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetCounterTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "Main") {
                    composable("Main") { MainScreen(navController) }
                    composable("SimpleCounter") { SimpleCounterScreen(navController, model) }
                }
            }
        }
    }
}