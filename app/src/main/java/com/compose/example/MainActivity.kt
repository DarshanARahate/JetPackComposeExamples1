package com.compose.example

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.example.ui.theme.JetPackComposeExamples1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
                    var counter = remember {
                        mutableStateOf(0)
                    }
                    LaunchedEffect(key1 = Unit) {
                        delay(2000)
                        counter.value = 10
                    }
                    Column {
                        RememberUpdatedStateComposable(counter.value)
                        App()
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeExamples1Theme {
        Greeting("Android")
    }
}

@Composable
fun RememberUpdatedStateComposable(value: Int) {
    val state = rememberUpdatedState(newValue = value)

    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("RememberUpdatedState", state.value.toString())
    }
    Text(text = value.toString())
}

fun a() { Log.d("RememberUpdatedState","I am A from App")  }

fun b() { Log.d("RememberUpdatedState","I am B from App")  }

@Composable
fun App() {
    var state = remember {
        mutableStateOf(::a)
    }
    Button(onClick = { state.value = ::b }) {
        Text(text = "Click to change state")
    }
    LandingScreen(state.value)
}

@Composable
fun LandingScreen(onTimeOut: () -> Unit) {
    val currentOnTimeout by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(5000)
        currentOnTimeout()
    }
}