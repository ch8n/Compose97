package io.github.ch8n.compose97.routes.desktop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.ui.components.desktop.Desktop
import io.github.ch8n.compose97.ui.components.startBar.StartBar
import io.github.ch8n.compose97.ui.components.startBar.StartBarProps
import io.github.ch8n.compose97.ui.components.startMenu.StartMenu
import io.github.ch8n.compose97.ui.screens.WindowsVM
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

            Desktop(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                desktopItemItems = viewModel.desktopItems
            )

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
                .height(42.dp),
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
