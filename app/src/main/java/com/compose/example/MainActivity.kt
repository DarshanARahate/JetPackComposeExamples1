package com.compose.example

import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
                        App1()
                        App2()
                        TextField(value = "", onValueChange = { })
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

@Composable
fun App1() {
    var state = remember {
        mutableStateOf(false)
    }

    DisposableEffect(key1 = state.value) {
        Log.d("DisposableEffect Log:", "Disposable Effect Started")
        onDispose {
            Log.d("DisposableEffect Log:", "Cleaning up side effects")
        }
    }

    Button(onClick = { state.value = !state.value }) {
        Text(text = "Click to change state")
    }
}

@Composable
fun App2() {
    val view = LocalView.current

    DisposableEffect(key1 = Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("DisposableEffect TAG:", isKeyboardVisible.toString())
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listener)

        Log.d("DisposableEffect Log:", "Disposable Effect Started")
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
            Log.d("DisposableEffect Log:", "Cleaning up side effects")
        }
    }


}
