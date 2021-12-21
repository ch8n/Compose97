package io.github.ch8n.compose97.routes.internetexplorer

import android.graphics.Bitmap
import android.os.Build
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView
import com.arkivanov.decompose.ComponentContext
import io.github.ch8n.compose97.Logger
import io.github.ch8n.compose97.navigation.AppNavigation
import io.github.ch8n.compose97.navigation.DecomposeComponent
import io.github.ch8n.compose97.routes.window97.Window97Common
import io.github.ch8n.compose97.ui.components.windowscaffold.StatusBarProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowAddressProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowScaffold

class InternetExplorerComponent(
    componentContext: ComponentContext
) : DecomposeComponent(componentContext) {

    private val internetExplorer = Window97Common.InternetExplorer

    val statusBar = StatusBarProps(
        title = internetExplorer.label,
        mainIcon = internetExplorer.iconId
    )

    val windowAddressProps = WindowAddressProps(
        iconRes = internetExplorer.iconId,
        name = internetExplorer.label,
        path = "https://chetangupta.net"
    )

    fun onMinimiseClicked() {}
    fun onMaximiseClicked() {}
    fun onCloseClicked() {}
}


@Composable
fun InternetExplorer(
    internetExplorerComponent: InternetExplorerComponent,
    navComponent: AppNavigation,
) {
    val myComputerProps = remember {
        WindowProps(
            statusBar = internetExplorerComponent.statusBar,
            toolbar = emptyList(),
            navToolbar = emptyList(),
            addressBar = internetExplorerComponent.windowAddressProps,
            isMaximised = true,
            showDetailPanel = false
        )
    }
    WindowScaffold(
        props = myComputerProps,
        onMinimiseClicked = internetExplorerComponent::onMinimiseClicked,
        onMaximiseClicked = internetExplorerComponent::onMaximiseClicked,
        onCloseClicked = internetExplorerComponent::onCloseClicked
    ) {
        ComposeWebView(
            url = internetExplorerComponent.windowAddressProps.path,
            onPageLoadingFinished = {

            },
            onPageLoadingStarted = {

            }
        )
    }
}

@Composable
private fun ComposeWebView(
    url: String,
    onPageLoadingStarted: () -> Unit,
    onPageLoadingFinished: () -> Unit,
) {
    var currentWebView: WebView? by remember { mutableStateOf(null) }

    DisposableEffect(key1 = currentWebView) {
        currentWebView ?: return@DisposableEffect onDispose { }
        onDispose {
            currentWebView = null
        }
    }

    BackHandler(enabled = currentWebView?.canGoBack() == true) {
        currentWebView?.goBack()
    }

    AndroidView(
        factory = {
            WebView(it).apply {
                with(settings) {
                    javaScriptEnabled = true
                    loadsImagesAutomatically = true
                }

                scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

                webViewClient = object : WebViewClient() {

                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        super.onPageStarted(view, url, favicon)
                        onPageLoadingStarted.invoke()
                    }

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        onPageLoadingFinished.invoke()
                    }

                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        return false
                    }

                    override fun onReceivedError(
                        view: WebView?,
                        errorCode: Int,
                        description: String?,
                        failingUrl: String?
                    ) {
                        super.onReceivedError(view, errorCode, description, failingUrl)
                        Logger.e("ch8n -> webview $description $failingUrl")
                    }

                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onReceivedError(
                        view: WebView?,
                        request: WebResourceRequest?,
                        error: WebResourceError?
                    ) {
                        super.onReceivedError(view, request, error)
                        Logger.e("ch8n -> webview ${error?.description}")
                    }
                }

                loadUrl(url)
            }
        },
    )
}

