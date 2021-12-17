package io.github.ch8n.compose97.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.router
import io.github.ch8n.compose97.routes.desktop.DesktopComponent
import io.github.ch8n.compose97.routes.window97.Window97AppComponent

abstract class NavigationComponent(
    componentContext: ComponentContext
) : DecomposeComponent(componentContext) {

    abstract val router: Router<Destinations, DecomposeComponent>

    private val window97 = Window97AppComponent(
        componentContext = this,
        router = router
    )

    @Composable
    override fun render() {
        window97.render()
    }

}


class AppNavigation(componentContext: ComponentContext) : NavigationComponent(componentContext) {

    override val router: Router<Destinations, DecomposeComponent>
        get() = router(
            initialConfiguration = Destinations.Desktop,
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
            is Destinations.Desktop -> DesktopComponent(context)
            is Destinations.Folder -> TODO()
            is Destinations.InternetExplorer -> TODO()
            is Destinations.MyComputer -> TODO()
            is Destinations.MyDocuments -> TODO()
            is Destinations.Notepad -> TODO()
            is Destinations.RecyclerBin -> TODO()
        }
    }

    companion object {
        fun previewComponent(componentContext: ComponentContext): NavigationComponent {
            return object : NavigationComponent(componentContext) {
                override val router: Router<Destinations, DecomposeComponent>
                    get() = router(
                        initialConfiguration = Destinations.Desktop,
                        childFactory = { _, context ->
                            DesktopComponent(context)
                        }
                    )
            }
        }

    }
}
