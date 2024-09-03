package com.compose.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
//                    Greeting("Android")
                    ListViewItem()
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
//        Greeting("Android")
        ListViewItem()
    }
}

@Composable
private fun ListViewItem() {
    Column {
        Spacer(modifier = Modifier.size(5.dp))
        LayoutFunction(imgId = R.drawable.ic_heart, name = "John Doe", occupation = "Software Engineer")
        Spacer(modifier = Modifier.size(5.dp))
        LayoutFunction(imgId = R.drawable.ic_heart, name = "Annie Shaw", occupation = "Technical Lead")
        Spacer(modifier = Modifier.size(5.dp))
        LayoutFunction(imgId = R.drawable.ic_heart, name = "James Leo", occupation = "Lead Engineer")
        Spacer(modifier = Modifier.size(5.dp))
        LayoutFunction(imgId = R.drawable.ic_heart, name = "Brad Shane", occupation = "Software Engineer")

    }
}

@Composable
private fun LayoutFunction(imgId: Int, name: String, occupation: String) {
    Row {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "",
            Modifier.size(40.dp)
        )

        Column {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)
        }
    }
}
