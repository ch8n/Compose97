package io.github.ch8n.compose97.ui.screens

import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.routes.desktop.DesktopItemProps
import io.github.ch8n.compose97.ui.components.startMenu.StartMenuItemProps

class WindowsVM {

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
}
