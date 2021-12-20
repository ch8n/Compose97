package io.github.ch8n.compose97.routes.desktop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.push
import io.github.ch8n.compose97.navigation.DecomposeComponent
import io.github.ch8n.compose97.navigation.Destinations
import io.github.ch8n.compose97.navigation.NavigationComponent
import io.github.ch8n.compose97.routes.window97.Window97Common

class DesktopComponent(
    componentContext: ComponentContext
) : DecomposeComponent(componentContext) {

    val desktopItems = listOf<Window97Common>(
        Window97Common.MyComputer,
        Window97Common.RecyclerBin,
        Window97Common.MyDocuments,
        Window97Common.InternetExplorer,
        Window97Common.Notepad
    )
}

@Composable
fun Desktop(
    modifier: Modifier,
    desktopComponent: DesktopComponent,
    navComponent: NavigationComponent,
) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            desktopComponent.desktopItems.forEach { desktopItem ->
                Spacer(modifier = Modifier.size(12.dp))
                DesktopItem(
                    window97Common = desktopItem,
                    onItemClicked = { window97Common ->
                        when (window97Common) {
                            Window97Common.InternetExplorer -> TODO()
                            Window97Common.MyComputer -> navComponent.router.push(Destinations.MyComputer)
                            Window97Common.MyDocuments -> navComponent.router.push(Destinations.MyDocuments)
                            Window97Common.Notepad -> TODO()
                            Window97Common.RecyclerBin -> navComponent.router.push(Destinations.RecyclerBin)
                        }
                    }
                )
            }
        }
    }
}
