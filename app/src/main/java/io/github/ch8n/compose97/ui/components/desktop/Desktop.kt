package io.github.ch8n.compose97.ui.components.desktop

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R


@Composable
fun Desktop(
    modifier: Modifier,
    desktopItemItems: List<DesktopItemProps>
) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            desktopItemItems.forEach {
                Spacer(modifier = Modifier.size(12.dp))
                DesktopItem(itemProps = it)
            }
        }
    }
}

@Preview
@Composable
fun DesktopPreview() {
    Desktop(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        desktopItemItems = listOf(
            DesktopItemProps(
                iconResId = R.drawable.my_computer_32x32,
                itemName = "My Computer",
                onItemClicked = {}
            ),
            DesktopItemProps(
                iconResId = R.drawable.recycle_bin_32x32,
                itemName = "Recycle Bin",
                onItemClicked = {},
            ),
            DesktopItemProps(
                iconResId = R.drawable.my_documents_folder_32x32,
                itemName = "My Documents",
                onItemClicked = {},
            ),
            DesktopItemProps(
                iconResId = R.drawable.internet_explorer_32x32,
                itemName = "Internet\nExplorer",
                onItemClicked = {},
            ),
            DesktopItemProps(
                iconResId = R.drawable.notepad_32x32,
                itemName = "Notepad",
                onItemClicked = {},
            ),
        )
    )
}