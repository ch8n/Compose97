import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.components.windowscaffold.StatusBarProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowAddressProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowScaffold


// TODO folders and search

data class Note(
    val name: String,
    val content: String,
    val updatedAt: Long,
    val group: String,
) {
    companion object {
        val SAMPLE
            get() = Note(
                name = "file",
                content = LoremIpsum().values.take(5).toString(),
                updatedAt = System.currentTimeMillis(),
                group = sampleGroup.random()
            )
    }
}

val sampleGroup = mutableListOf<String>().apply {
    repeat(10) {
        add("folder${it + 1}")
    }
}

val sampleNotes = mutableListOf<Note>().apply {
    repeat(100) {
        add(Note.SAMPLE.copy(name = "File ${it + 1}"))
    }
}


@Composable
fun MyComputer(
    onMinimiseClicked: () -> Unit,
    onMaximiseClicked: () -> Unit,
    onCloseClicked: () -> Unit,
) {
    val myComputerProps = remember {
        WindowProps(
            statusBar = StatusBarProps(
                title = "(C:)",
                mainIcon = R.drawable.drive_32x32
            ),
            toolbar = emptyList(),
            navToolbar = emptyList(),
            addressBar = WindowAddressProps(
                iconRes = R.drawable.drive_32x32,
                name = "(C:)",
                path = "C://"
            ),
            isMaximised = true
        )
    }
    WindowScaffold(
        props = myComputerProps,
        onMinimiseClicked = onMinimiseClicked,
        onMaximiseClicked = onMaximiseClicked,
        onCloseClicked = onCloseClicked
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            sampleNotes.groupBy { it.group }.forEach { (key, value) ->
                item {
                    Text(text = key)
                }

                items(value.chunked(4)) { set4Notes ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        set4Notes.forEach { Icon(note = it) }
                    }
                }

                item {
                    Divider()
                }
            }
        }
    }
}

@Composable
private fun Icon(note: Note) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.notepad_file_32x32),
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Text(
            text = note.name,
            style = MaterialTheme.typography.caption,
        )
    }
}


@Preview
@Composable
fun MyComputerPreview() {
    io.github.ch8n.compose97.ui.components.Preview {
        MyComputer(
            onMaximiseClicked = {},
            onMinimiseClicked = {},
            onCloseClicked = {},
        )
    }
}