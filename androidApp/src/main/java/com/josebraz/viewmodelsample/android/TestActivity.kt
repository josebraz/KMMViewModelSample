package com.josebraz.viewmodelsample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.josebraz.viewmodelsample.SampleViewModel
import com.josebraz.viewmodelsample.android.ui.theme.investTheme

class TestActivity : ComponentActivity() {
    private val viewModel: SampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.startClock()

        setContent {
            investTheme {
                // A surface container using the 'background' color from the theme
                val state = viewModel.stateFlow.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(state.value.counter, state.value.time) {
                        viewModel.increment()
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    counter: Int,
    clock: String,
    increment: () -> Unit = { }
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = clock,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Counter: $counter",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = increment) {
            Text(text = "INCREMENT")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    investTheme {
        MainScreen(5, "14:00")
    }
}