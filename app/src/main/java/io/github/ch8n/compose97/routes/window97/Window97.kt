package io.github.ch8n.compose97.routes.window97

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.navigation.DecomposeComponent
import io.github.ch8n.compose97.navigation.NavigationComponent
import io.github.ch8n.compose97.routes.desktop.Desktop
import io.github.ch8n.compose97.routes.desktop.DesktopComponent
import io.github.ch8n.compose97.ui.components.startBar.StartBar
import io.github.ch8n.compose97.ui.components.startBar.StartBarProps
import io.github.ch8n.compose97.ui.components.startBar.StartTabProps
import io.github.ch8n.compose97.ui.components.startMenu.StartMenu
import io.github.ch8n.compose97.ui.components.startMenu.StartMenuItemProps
import io.github.ch8n.compose97.ui.theme.Teal

class Window97AppComponent(
    componentContext: ComponentContext,
) : DecomposeComponent(componentContext) {

    val startMenuItems = listOf(
        StartMenuItemProps(
            iconId = R.drawable.my_computer_32x32,
            name = "My Computer",
            onItemClick = {
            }
        ),
        StartMenuItemProps(
            iconId = R.drawable.recycle_bin_32x32,
            name = "Recycle Bin",
            onItemClick = {}
        ),
        StartMenuItemProps(
            iconId = R.drawable.my_documents_folder_32x32,
            name = "My Documents",
            onItemClick = {}
        ),
        StartMenuItemProps(
            iconId = R.drawable.internet_explorer_32x32,
            name = "Internet Explorer",
            onItemClick = {}
        ),
        StartMenuItemProps(
            iconId = R.drawable.notepad_32x32,
            name = "Notepad",
            onItemClick = {}
        ),
    )
    val starBarTabs = listOf<StartTabProps>()
}


@Composable
fun Window97(
    navComponent: NavigationComponent,
    window97Component: Window97AppComponent
) {
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

            Children(routerState = navComponent.router.state) { child ->
                val component = child.instance
                when (component) {
                    is DesktopComponent -> Desktop(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        desktopComponent = component
                    )
                }
            }

            if (isStartMenuOpen) {
                StartMenu(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .align(Alignment.BottomStart),
                    menuItems = window97Component.startMenuItems
                )
            }
        }
        StartBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            props = StartBarProps(
                tabs = window97Component.starBarTabs,
                onStartButtonClicked = {
                    setStartMenuOpen(!isStartMenuOpen)
                }
            )
        )
    }
}

