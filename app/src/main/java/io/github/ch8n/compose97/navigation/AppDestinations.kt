package io.github.ch8n.compose97.navigation

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

sealed class Destinations : Parcelable {
    @Parcelize
    object Desktop : Destinations()

    @Parcelize
    object MyComputer : Destinations()

    @Parcelize
    object MyDocuments : Destinations()

    @Parcelize
    object RecyclerBin : Destinations()

    @Parcelize
    object InternetExplorer : Destinations()

    @Parcelize
    object Notepad : Destinations()

    @Parcelize
    data class Folder(val groupId: String) : Destinations()
}