package com.jppin.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jppin.composelearning.ui.HomeScreen
import com.jppin.composelearning.ui.theme.ComposeLearningTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                HomeScreen()
            }
        }
    }
}
