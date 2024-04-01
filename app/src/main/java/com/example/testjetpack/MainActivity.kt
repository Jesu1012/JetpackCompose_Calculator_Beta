package com.example.testjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.testjetpack.ui.theme.TestJetpackTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayoutContent()

                }
            }
        }
    }
}

class Conection{
    //c++ Conection
    external fun SentDataAndChecking(param:String): Boolean
    external fun ReceiveData(param:String): String

    companion object {
        init {
            System.loadLibrary("testjetpack")
        }
    }

}

@Composable
fun ConstraintLayoutContent() {
    var varState = remember { mutableStateOf("") }
    val buttonColors = ButtonDefaults.buttonColors(
        contentColor = Color.Red // Cambia el color del texto a rojo
    )
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        ConstraintLayout{
            val (button1Ref, button2Ref, button3Ref, button4Ref,
                button5Ref, button6Ref,button7Ref, button8Ref,
                button9Ref, button10Ref,button11Ref, button12Ref,
                button13Ref, button14Ref,button15Ref, button16Ref
            ) = createRefs()
            val (button17Ref, button18Ref,button19Ref, button20Ref) = createRefs()
            Button(
                onClick = { varState.value = "" },

                modifier = Modifier.constrainAs(button1Ref) {

                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)

                }

            ) {
                Text("C")
            }
            Button(
                onClick = { /* Do something */ },

                modifier = Modifier.constrainAs(button2Ref) {

                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(button1Ref.end, margin = 16.dp)

                },

                colors = buttonColors

            ) {
                Text(
                    "<x")
            }
            Button(
                onClick = { /* Do something */ },

                modifier = Modifier.constrainAs(button3Ref) {

                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(button2Ref.end, margin = 16.dp)

                },
                colors = buttonColors

            ) {
                Text("%")
            }
            Button(
                onClick = { varState.value += "/"  },

                modifier = Modifier.constrainAs(button4Ref) {

                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(button3Ref.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }

            ) {
                Text("/")
            }
            //
            Button(
                onClick = { varState.value += "7"  },

                modifier = Modifier.constrainAs(button5Ref) {

                    top.linkTo(button1Ref.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)

                }

            ) {
                Text("7")
            }
            Button(
                onClick = { varState.value += "8"  },

                modifier = Modifier.constrainAs(button6Ref) {

                    top.linkTo(button1Ref.bottom, margin = 16.dp)
                    start.linkTo(button1Ref.end, margin = 16.dp)

                }

            ) {
                Text("8")
            }
            Button(
                onClick = { varState.value += "9" },

                modifier = Modifier.constrainAs(button7Ref) {

                    top.linkTo(button1Ref.bottom, margin = 16.dp)
                    start.linkTo(button2Ref.end, margin = 16.dp)

                }

            ) {
                Text("9")
            }
            Button(
                onClick = { varState.value += "*"  },

                modifier = Modifier.constrainAs(button8Ref) {

                    top.linkTo(button1Ref.bottom, margin = 16.dp)
                    start.linkTo(button3Ref.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }

            ) {
                Text("X")
            }
            //
            //
            Button(
                onClick = { varState.value += "4" },

                modifier = Modifier.constrainAs(button9Ref) {

                    top.linkTo(button5Ref.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)

                }

            ) {
                Text("4")
            }
            Button(
                onClick = { varState.value += "5" },

                modifier = Modifier.constrainAs(button10Ref) {

                    top.linkTo(button5Ref.bottom, margin = 16.dp)
                    start.linkTo(button1Ref.end, margin = 16.dp)

                }

            ) {
                Text("5")
            }
            Button(
                onClick = { varState.value += "6" },

                modifier = Modifier.constrainAs(button11Ref) {

                    top.linkTo(button5Ref.bottom, margin = 16.dp)
                    start.linkTo(button2Ref.end, margin = 16.dp)

                }

            ) {
                Text("6")
            }
            Button(
                onClick = { varState.value += "-" },

                modifier = Modifier.constrainAs(button12Ref) {

                    top.linkTo(button5Ref.bottom, margin = 16.dp)
                    start.linkTo(button3Ref.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }

            ) {
                Text("-")
            }
            //
            //
            //
            Button(
                onClick = { varState.value += "1" },

                modifier = Modifier.constrainAs(button13Ref) {

                    top.linkTo(button9Ref.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)

                }

            ) {
                Text("1")
            }
            Button(
                onClick = { varState.value += "2"  },

                modifier = Modifier.constrainAs(button14Ref) {

                    top.linkTo(button9Ref.bottom, margin = 16.dp)
                    start.linkTo(button1Ref.end, margin = 16.dp)

                }

            ) {
                Text("2")
            }
            Button(
                onClick = { varState.value += "3"  },

                modifier = Modifier.constrainAs(button15Ref) {

                    top.linkTo(button9Ref.bottom, margin = 16.dp)
                    start.linkTo(button2Ref.end, margin = 16.dp)

                }

            ) {
                Text("3")
            }
            Button(
                onClick = { varState.value += "+"  },

                modifier = Modifier.constrainAs(button16Ref) {

                    top.linkTo(button9Ref.bottom, margin = 16.dp)
                    start.linkTo(button3Ref.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }

            ) {
                Text("+")
            }
            //
            //
            //
            //
            Button(
                onClick = { /* Do something */ },

                modifier = Modifier.constrainAs(button17Ref) {

                    top.linkTo(button13Ref.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)

                },

                colors = buttonColors

            ) {
                Text("ex")
            }
            Button(
                onClick = { varState.value += "0" },

                modifier = Modifier.constrainAs(button18Ref) {

                    top.linkTo(button13Ref.bottom, margin = 16.dp)
                    start.linkTo(button1Ref.end, margin = 16.dp)

                }

            ) {
                Text("0")
            }
            Button(
                onClick = { /* Do something */ },

                modifier = Modifier.constrainAs(button19Ref) {

                    top.linkTo(button13Ref.bottom, margin = 16.dp)
                    start.linkTo(button2Ref.end, margin = 16.dp)

                },
                colors = buttonColors

            ) {
                Text(".")
            }
            Button(
                onClick = {

                    var linked = Conection();

                    var checking = linked.SentDataAndChecking(varState.value)

                    if (checking){
                        varState.value = "";

                    }else{
                        var responseAlgorithm = linked.ReceiveData(varState.value)
                        varState.value = responseAlgorithm;
                    }
                          },

                modifier = Modifier.constrainAs(button20Ref) {

                    top.linkTo(button13Ref.bottom, margin = 16.dp)
                    start.linkTo(button3Ref.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }

            ) {
                Text("=")
            }
            //

        }
    }
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        AssistChip(
            onClick = { println("Holi") },
            label = {
                Text(
                    text = varState.value,
                    fontSize = 20.sp
                )
                    },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            },
            modifier = Modifier.size(width = 300.dp, height = 50.dp)
        )

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestJetpackTheme {
        ConstraintLayoutContent()
    }
}