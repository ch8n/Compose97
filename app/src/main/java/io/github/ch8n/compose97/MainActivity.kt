package io.github.ch8n.compose97

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.ch8n.compose97.ui.components.Preview
import io.github.ch8n.compose97.ui.components.startbar.StartMenu
import io.github.ch8n.compose97.ui.components.taskbar.StartBar
import io.github.ch8n.compose97.ui.components.taskbar.StartBarProps
import io.github.ch8n.compose97.ui.theme.Compose97Theme
import io.github.ch8n.compose97.ui.theme.Teal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compose97App()
    }

    private fun compose97App() {
        setContent {
            Compose97Theme {
                Window97()
            }
        }
    }
}

@Preview
@Composable
fun Window97Preview() {
    Preview {
        Window97()
    }
}

@Composable
fun Window97() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val (isStartMenuOpen, setStartMenuOpen) = remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Teal)
                .weight(1f, fill = true),
        ) {

            if (isStartMenuOpen) {
                //StartMenu()
            }

        }
        StartBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            props = StartBarProps(
                tabs = emptyList(),
                onStartButtonClicked = {
                    setStartMenuOpen(!isStartMenuOpen)
                }
            )
        )
    }
}
