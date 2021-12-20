package io.github.ch8n.compose97.ui.components

import io.github.ch8n.compose97.R

sealed class WindowIconType(
    open val name: String,
    open val icon: Int
) {
    data class Folder(
        override val name: String,
        override val icon: Int = R.drawable.folder_32x32
    ) : WindowIconType(name, icon)

    data class Drive(
        override val name: String,
        override val icon: Int = R.drawable.drive_32x32
    ) : WindowIconType(name, icon)

    data class TxtFile(
        override val name: String,
        override val icon: Int = R.drawable.notepad_file_32x32
    ) : WindowIconType(name, icon)
}
