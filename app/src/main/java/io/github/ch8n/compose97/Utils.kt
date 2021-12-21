package io.github.ch8n.compose97

import io.github.aakira.napier.Napier

object Logger {
    fun d(message: String) {
        Napier.d(message)
    }

    fun e(message: String = "", throwable: Throwable? = null) {
        Napier.e(message, throwable)
    }
}