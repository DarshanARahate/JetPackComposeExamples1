package com.compose.example

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
                    Column {
                        Derived()
                        Loader()
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

@SuppressLint("UnrememberedMutableState")
@Composable
private fun Derived() {
    val tableOf = remember {
        mutableStateOf(5)
    }

    val index = produceState(initialValue = 1) {
        repeat(9) {
            delay(1000)
            value += 1
        }
    }

    val message = derivedStateOf {
        "${tableOf.value} * ${index.value} = ${tableOf.value * index.value}"
    }

    Box{
        Text(text = message.value, style = MaterialTheme.typography.labelLarge)
    }


}

@Composable
fun Loader() {
    val degree = produceState(initialValue = 0) {
        while (true) {
            delay(160)
            value = (value + 30) % 360
        }
    }

    Box(
//        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f),
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    imageVector = Default.Refresh, contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(degree.value.toFloat())
                )
                Text(text = "Loading...")
            }
        })
}