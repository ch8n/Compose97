package io.github.ch8n.compose97

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import io.github.ch8n.compose97.navigation.AppNavigation
import io.github.ch8n.compose97.navigation.NavigationComponent
import io.github.ch8n.compose97.routes.window97.Window97
import io.github.ch8n.compose97.routes.window97.Window97AppComponent
import io.github.ch8n.compose97.ui.theme.Compose97Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compose97App()
    }

    private fun compose97App() {
        val componentContext = defaultComponentContext()
        val rootNavComponent: NavigationComponent = AppNavigation(componentContext)
        val window97Component = Window97AppComponent(componentContext)
        setContent {
            Compose97Theme {
                Window97(
                    window97Component = window97Component,
                    navComponent = rootNavComponent
                )
            }
        }
    }
}
