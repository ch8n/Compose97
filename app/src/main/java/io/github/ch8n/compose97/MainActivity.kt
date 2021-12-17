package io.github.ch8n.compose97

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import io.github.ch8n.compose97.navigation.AppNavigation
import io.github.ch8n.compose97.navigation.NavigationComponent
import io.github.ch8n.compose97.ui.theme.Compose97Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compose97App()
    }

    private fun compose97App() {
        val rootNavigationComponent = AppNavigation(defaultComponentContext())
        setContent {
            Compose97Theme {
                rootNavigationComponent.render()
            }
        }
    }
}

