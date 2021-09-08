package io.github.ch8n.compose97

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.ui.theme.Black
import io.github.ch8n.compose97.ui.theme.Compose97Theme
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.ui.theme.Teal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose97Theme {
                Surface(
                    color = Teal,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.95f)
                        ) {
                            Text(text = "Hello 1")
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .background(Silver)
                        ) {

                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Black
                                    )
                                    .shadow(
                                        elevation = 2.dp
                                    )
                            ) {
                                Row {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_windows95),
                                        contentDescription = "start button"
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "Start",
                                        style = MaterialTheme.typography.button
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose97Theme {
        Greeting("Android")
    }
}