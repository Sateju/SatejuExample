package com.jjtelechea.satejuexample.ui.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jjtelechea.satejuexample.ui.theme.SatejuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SatejuTheme {
                ListScreen()
            }
        }
    }
}