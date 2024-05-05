package com.example.testjetpack

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testjetpack.ui.theme.TestJetpackTheme

@Composable
fun MySootheAppPortrait() {
    TestJetpackTheme {
        Scaffold(
            bottomBar = { SootheBottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}@Composable
fun MySootheAppLandscape() {
    TestJetpackTheme {
        Row {
            SootheNavigationRail()
            HomeScreen()
        }
    }
}
@Preview
@Composable
private fun SootheNavigationRailPreview() {
    MySootheAppLandscape()
}