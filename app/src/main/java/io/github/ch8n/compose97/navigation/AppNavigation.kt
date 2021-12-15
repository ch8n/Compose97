package io.github.ch8n.compose97.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.router
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

abstract class DecomposeComponent(
    private val componentContext: ComponentContext
) : ComponentContext by componentContext {

    @Composable
    abstract fun render()
}


class NavigationComponent(componentContext: ComponentContext) :
    DecomposeComponent(componentContext) {


    private sealed class Destinations : Parcelable

    @Parcelize
    private object Desktop : Destinations()

    @Parcelize
    private object MyComputer : Destinations()

    @Parcelize
    private object MyDocuments : Destinations()

    @Parcelize
    private object RecyclerBin : Destinations()

    @Parcelize
    private object InternetExplorer : Destinations()

    @Parcelize
    private object Notepad : Destinations()

    @Parcelize
    private data class Folder(val groupId: String) : Destinations()

    private val router: Router<Destinations, DecomposeComponent> = router(
        initialConfiguration = Desktop,
        initialBackStack = emptyList(),
        key = "RootRouter",
        handleBackButton = false,
        childFactory = ::createDestinations
    )

    private fun createDestinations(
        destinations: Destinations,
        context: ComponentContext
    ): DecomposeComponent {
        return when (destinations) {
            is Desktop -> TODO()
            is Folder -> TODO()
            is InternetExplorer -> TODO()
            is MyComputer -> TODO()
            is MyDocuments -> TODO()
            is Notepad -> TODO()
            is RecyclerBin -> TODO()
        }
    }

    @Composable
    override fun render() {

    }


}
