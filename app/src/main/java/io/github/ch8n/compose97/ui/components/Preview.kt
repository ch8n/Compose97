package io.github.ch8n.compose97.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.ch8n.compose97.ui.theme.Compose97Theme

@Composable
fun Preview(content: @Composable () -> Unit) {
    Compose97Theme {
        Box(modifier = Modifier.fillMaxSize()) {
            content.invoke()
        }
    }
}
