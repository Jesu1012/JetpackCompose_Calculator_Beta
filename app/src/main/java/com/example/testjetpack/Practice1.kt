package com.example.testjetpack

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.activity.ComponentActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import com.example.testjetpack.ui.theme.TestJetpackTheme




class Practice1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestJetpackTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    var activePanel by remember { mutableStateOf(0) } // Initially, panel 0 is active
                    Column {
                        // Row for buttons
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                            Button(onClick = { activePanel = 0 }) {
                                Text("Panel 1")
                            }
                            Button(onClick = { activePanel = 1 }) {
                                Text("Panel 2")
                            }
                            // Add more buttons for additional panels as needed
                        }

                        // Conditional rendering of panels based on active state
                        when (activePanel) {
                            0 -> Panel1Content()
                            1 -> Panel2Content()
                            else -> Text("Invalid panel index") // Handle unexpected cases
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Panel1Content() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(100.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Panel 1 Content")
            // Add specific content for Panel 1 here
        }
    }
}

@Composable
fun Panel2Content() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Panel 2 Content")
            // Add specific content for Panel 2 here
        }
    }
}

// Add more panel content Composable functions as needed
