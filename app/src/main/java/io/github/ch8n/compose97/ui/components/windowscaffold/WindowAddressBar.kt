package io.github.ch8n.compose97.ui.components.windowscaffold

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.Black
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.ui.theme.White

data class WindowAddressProps(
    @DrawableRes val iconRes: Int,
    val path: String,
    val name: String,
) {
    companion object {
        val Empty = WindowAddressProps(
            iconRes = R.drawable.ic_windows95,
            path = "~/",
            name = "Blank"
        )
    }
}

@Composable
fun WindowAddressBar(
    props: WindowAddressProps,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .background(Silver)
            .padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Address",
            style = MaterialTheme.typography.caption
        )

        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .border(1.dp, Black)
                .shadow(2.dp)
                .background(White)
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                painter = painterResource(id = props.iconRes),
                modifier = Modifier.size(12.dp),
                contentDescription = null,
                tint = Color.Unspecified
            )

            Text(
                text = props.path,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Preview
@Composable
fun WindowAddressBarPreview() {
    io.github.ch8n.compose97.ui.components.Preview {
        WindowAddressBar(
            props = WindowAddressProps(
                iconRes = R.drawable.my_computer_32x32,
                path = """C://""",
                name = "C:"
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
