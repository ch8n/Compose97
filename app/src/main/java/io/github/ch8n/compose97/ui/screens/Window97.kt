package io.github.ch8n.compose97.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.ui.components.Preview
import io.github.ch8n.compose97.ui.components.startbar.StartMenu
import io.github.ch8n.compose97.ui.components.taskbar.StartBar
import io.github.ch8n.compose97.ui.components.taskbar.StartBarProps
import io.github.ch8n.compose97.ui.theme.Teal

@Composable
fun Window97() {
    val viewModel = remember { WindowsVM() }
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
                StartMenu(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .align(Alignment.BottomStart),
                    menuItems = viewModel.startMenuItems
                )
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

@Preview
@Composable
fun Window97Preview() {
    io.github.ch8n.compose97.ui.components.Preview {
        Window97()
    }
}