package com.compose.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.example.ui.theme.JetPackComposeExamples1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeExamples1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Greeting("Android")
                        Spacer(modifier = Modifier.height(5.dp))
                        TextFunction()
                        Spacer(modifier = Modifier.height(5.dp))
                        ImageFunction()
                        Spacer(modifier = Modifier.height(5.dp))
                        ButtonFunction()
                        Spacer(modifier = Modifier.height(5.dp))
                        TextInput()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetPackComposeExamples1Theme {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Greeting("Android")
            Spacer(modifier = Modifier.height(5.dp))
            TextFunction()
            Spacer(modifier = Modifier.height(5.dp))
            ImageFunction()
            Spacer(modifier = Modifier.height(5.dp))
            ButtonFunction()
            Spacer(modifier = Modifier.height(5.dp))
            TextInput()
        }
    }
}

@Composable
private fun TextFunction() {
    Text(
        text = "Hello World",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Red,
        fontSize = 16.sp,
        textAlign = TextAlign.Left
    )
}

@Composable
private fun ImageFunction() {
    Image(
        painter = painterResource(id = R.drawable.ic_heart),
        contentDescription = "Dummy Image",
        colorFilter = ColorFilter.tint(Color.Blue),
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun ButtonFunction() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White
        ),
        enabled = true
    ) {
        Text(
            text = "Hello",
            modifier = Modifier.width(35.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = "Dummy"
        )
    }
}

@Composable
private fun TextInput() {
    val state = remember {
        mutableStateOf("")
    }

    TextField(value = state.value,
        onValueChange = {
            state.value = it
        },
        label = { Text(text = "Enter Message") }
    )

}
