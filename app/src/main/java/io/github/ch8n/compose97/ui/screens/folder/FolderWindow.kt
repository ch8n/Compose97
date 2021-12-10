package io.github.ch8n.compose97.ui.screens.folder

import Note
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.components.windowscaffold.*
import sampleNotes
import java.util.*

sealed class FolderWindowEvent {
    object OnMinimized : FolderWindowEvent()
    object OnMaximized : FolderWindowEvent()
    object OnClosed : FolderWindowEvent()
    object OnNewNote : FolderWindowEvent()
    object OnSearch : FolderWindowEvent()
    data class OnOpenNote(val note: Note) : FolderWindowEvent()
    data class OnDeleteNote(val notes: List<Note>) : FolderWindowEvent()
}


@Composable
fun FolderWindow(
    folderProps: WindowProps,
    files: List<Note>,
    onEvent: (FolderWindowEvent) -> Unit
) {
    WindowScaffold(
        props = folderProps,
        onMinimiseClicked = {
            onEvent.invoke(FolderWindowEvent.OnMinimized)
        },
        onMaximiseClicked = {
            onEvent.invoke(FolderWindowEvent.OnMaximized)
        },
        onCloseClicked = {
            onEvent.invoke(FolderWindowEvent.OnClosed)
        },
    ) {
        FolderWindowContent(
            files = files,
            onFileClicked = {
                onEvent.invoke(FolderWindowEvent.OnOpenNote(it))
            },
        )
    }
}

@Composable
fun FolderWindowContent(
    files: List<Note>,
    onFileClicked: (Note) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = rememberLazyListState(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(files.chunked(4)) { set4Notes ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                set4Notes.forEach { note ->
                    NotePadIcon(
                        note = note,
                        onNoteClicked = {
                            onFileClicked.invoke(note)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun NotePadIcon(
    note: Note,
    onNoteClicked: () -> Unit
) {
    Column(
        modifier = Modifier.clickable(onClick = onNoteClicked),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
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
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.widthIn(max = 64.dp)
        )
    }
}


@Preview
@Composable
fun FolderPreview() {
    io.github.ch8n.compose97.ui.components.Preview {
        val folderWindowProps = remember {
            WindowProps(
                statusBar = StatusBarProps(
                    title = "Chetan",
                    mainIcon = R.drawable.folder_32x32
                ),
                toolbar = emptyList(),
                navToolbar = listOf(
                    NavToolbarProp(
                        name = "Back",
                        iconRes = R.drawable.ic_back_navtool,
                        onOptionClicked = {}
                    ),
                    NavToolbarProp(
                        name = "Forward",
                        iconRes = R.drawable.ic_forward_navtool,
                        onOptionClicked = {}
                    ),
                    NavToolbarProp(
                        name = "Up",
                        iconRes = R.drawable.ic_up_navtool,
                        onOptionClicked = {}
                    ),
                ) + listOf(
                    NavToolbarProp(
                        isExtra = true,
                        name = "Create",
                        iconRes = R.drawable.ic_new_note_nav,
                        onOptionClicked = {
                            //  onEvent.invoke(FolderWindowEvent.OnNewNote)
                        }
                    ),
                    NavToolbarProp(
                        isExtra = true,
                        name = "Delete",
                        iconRes = R.drawable.ic_delete_navtool,
                        onOptionClicked = {
                            val notes = listOf<Note>()
                            // onEvent.invoke(FolderWindowEvent.OnDeleteNote(notes))
                        }
                    ),
                    NavToolbarProp(
                        isExtra = true,
                        name = "Search",
                        iconRes = R.drawable.ic_search,
                        onOptionClicked = {
                            // onEvent.invoke(FolderWindowEvent.OnSearch)
                        }
                    ),
                ),
                addressBar = WindowAddressProps(
                    iconRes = R.drawable.folder_32x32,
                    name = "Chetan",
                    path = "C://Chetan"
                ),
                isMaximised = true
            )
        }

        FolderWindow(
            folderProps = folderWindowProps,
            files = sampleNotes
                .groupBy { it.group }
                .values
                .toList()
                .first()
                .map { it.copy(name = UUID.randomUUID().toString()) },
            onEvent = { event ->
                when (event) {
                    FolderWindowEvent.OnClosed -> {}
                    is FolderWindowEvent.OnDeleteNote -> {}
                    FolderWindowEvent.OnMaximized -> {}
                    FolderWindowEvent.OnMinimized -> {}
                    FolderWindowEvent.OnNewNote -> {}
                    is FolderWindowEvent.OnOpenNote -> {}
                    FolderWindowEvent.OnSearch -> {}
                }
            }
        )
    }
}