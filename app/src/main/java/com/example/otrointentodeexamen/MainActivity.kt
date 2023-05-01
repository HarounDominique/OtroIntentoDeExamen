package com.example.otrointentodeexamen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.otrointentodeexamen.ui.theme.OtroIntentoDeExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtroIntentoDeExamenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirstScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen() {
    var isFirstScreen by rememberSaveable { mutableStateOf(false) }
    var textFieldValue by rememberSaveable { mutableStateOf("") }
    if (isFirstScreen) {
        Column() {
            TextField(value = textFieldValue, onValueChange = { textFieldValue = it })
            Button(onClick = {
                for (i in textFieldValue.toInt() downTo 1) {
                    contadores()
                }
            }) {
                Text(text = "Mostrar contadores")
            }

        }
    }
}
@Composable
fun contadores(){
    var CounterTextValue by rememberSaveable {
        mutableStateOf(0)
    }
    Row(){
        Button(onClick = { CounterTextValue = CounterTextValue-- }) {
            Text(text = "-")
        }
        Text(text = CounterTextValue.toString())
        Button(onClick = { CounterTextValue = CounterTextValue++ }) {
            Text(text = "+")
        }
    }
}