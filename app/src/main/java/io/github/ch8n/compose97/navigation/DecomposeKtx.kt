package io.github.ch8n.compose97.navigation

import com.arkivanov.decompose.ComponentContext

abstract class DecomposeComponent(
    private val componentContext: ComponentContext
) : ComponentContext by componentContext
