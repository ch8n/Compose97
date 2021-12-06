package io.github.ch8n.compose97

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.ch8n.compose97.ui.components.Preview
import io.github.ch8n.compose97.ui.screens.Window97
import io.github.ch8n.compose97.ui.theme.Compose97Theme

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
