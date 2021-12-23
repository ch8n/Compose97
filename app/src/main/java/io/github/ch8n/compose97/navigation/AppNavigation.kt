package io.github.ch8n.compose97.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.router
import io.github.ch8n.compose97.routes.desktop.DesktopComponent
import io.github.ch8n.compose97.routes.internetexplorer.InternetExplorerComponent
import io.github.ch8n.compose97.routes.mycomputer.MyComputerComponent
import io.github.ch8n.compose97.routes.mydocuments.MyDocumentComponent
import io.github.ch8n.compose97.routes.notepad.NotePadComponent
import io.github.ch8n.compose97.routes.recyclebin.RecycleBinComponent


class AppNavigation(componentContext: ComponentContext) : DecomposeComponent(componentContext) {

    val router: Router<Destinations, DecomposeComponent> = router(
        initialConfiguration = Destinations.Desktop,
        childFactory = ::createDestinations,
        handleBackButton = true
    )

    private fun createDestinations(
        destinations: Destinations,
        context: ComponentContext
    ): DecomposeComponent {
        return when (destinations) {
            is Destinations.Desktop -> DesktopComponent(context)
            is Destinations.Folder -> TODO()
            is Destinations.InternetExplorer -> InternetExplorerComponent(context)
            is Destinations.MyComputer -> MyComputerComponent(context)
            is Destinations.MyDocuments -> MyDocumentComponent(context)
            is Destinations.Notepad -> NotePadComponent(context)
            is Destinations.RecyclerBin -> RecycleBinComponent(context)
        }
    }
}
