package io.github.ch8n.compose97.routes.window97

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.navigation.AppNavigation
import io.github.ch8n.compose97.navigation.DecomposeComponent
import io.github.ch8n.compose97.navigation.Destinations
import io.github.ch8n.compose97.routes.desktop.DesktopItemProps
import io.github.ch8n.compose97.ui.components.startBar.StartBar
import io.github.ch8n.compose97.ui.components.startBar.StartBarProps
import io.github.ch8n.compose97.ui.components.startBar.StartTabProps
import io.github.ch8n.compose97.ui.components.startMenu.StartMenu
import io.github.ch8n.compose97.ui.components.startMenu.StartMenuItemProps
import io.github.ch8n.compose97.ui.screens.WindowsVM
import io.github.ch8n.compose97.ui.theme.Teal

class Window97AppComponent(
    componentContext: ComponentContext,
    private val router: Router<Destinations, DecomposeComponent>,
) : DecomposeComponent(componentContext) {

    private val startMenuItems = listOf(
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

    private val desktopItems = listOf(
        DesktopItemProps(
            iconResId = R.drawable.my_computer_32x32,
            itemName = "My Computer",
        ),
        DesktopItemProps(
            iconResId = R.drawable.recycle_bin_32x32,
            itemName = "Recycle Bin",
        ),
        DesktopItemProps(
            iconResId = R.drawable.my_documents_folder_32x32,
            itemName = "My Documents",
        ),
        DesktopItemProps(
            iconResId = R.drawable.internet_explorer_32x32,
            itemName = "Internet\nExplorer",
        ),
        DesktopItemProps(
            iconResId = R.drawable.notepad_32x32,
            itemName = "Notepad",
        ),
    )

    private val starBarTabs: MutableList<StartTabProps> = mutableListOf()

    @Composable
    override fun render() {
        Window97(
            router = router.state,
            desktopItems = desktopItems,
            startMenuItems = startMenuItems,
            starBarTabs = starBarTabs
        )
    }

}


@Composable
fun Window97(
    router: Value<RouterState<Destinations, DecomposeComponent>>,
    desktopItems: List<DesktopItemProps>,
    startMenuItems: List<StartMenuItemProps>,
    starBarTabs: MutableList<StartTabProps>,
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

            Children(routerState = router) { child ->
                child.instance.render()
            }

            if (isStartMenuOpen) {
                StartMenu(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .align(Alignment.BottomStart),
                    menuItems = startMenuItems
                )
            }
        }
        StartBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            props = StartBarProps(
                tabs = starBarTabs,
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
    val previewRouter = AppNavigation.previewComponent(TODO()).router
    io.github.ch8n.compose97.ui.components.Preview {
        Window97(
            router = previewRouter.state,
            desktopItems = emptyList(),
            startMenuItems = emptyList(),
            starBarTabs = mutableListOf()
        )
    }
}


