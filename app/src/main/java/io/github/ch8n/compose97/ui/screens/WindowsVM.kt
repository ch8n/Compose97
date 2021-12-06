package io.github.ch8n.compose97.ui.screens

import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.components.startbar.StartMenuItemProps

class WindowsVM {

    val startMenuItems = listOf(
        StartMenuItemProps(
            iconId = R.drawable.my_computer_32x32,
            name = "My Computer",
            onItemClick = {}
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



}