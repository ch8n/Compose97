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
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.navigation.DecomposeComponent


class DesktopComponent(
    componentContext: ComponentContext,
) : DecomposeComponent(componentContext) {

    val desktopItems = listOf(
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

    fun onDesktopItemClicked(desktopItem: DesktopItemProps) {
        // do stuff
    }
}

@Composable
fun Desktop(
    modifier: Modifier,
    desktopComponent: DesktopComponent
) {
    Box(modifier = modifier) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            desktopComponent.desktopItems.forEach { desktopItem ->
                Spacer(modifier = Modifier.size(12.dp))
                DesktopItem(
                    itemProps = desktopItem,
                    onItemClicked = desktopComponent::onDesktopItemClicked
                )
            }
        }
    }
}