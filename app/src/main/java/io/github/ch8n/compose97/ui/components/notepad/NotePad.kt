// package io.github.ch8n.compose97.ui.components.notepad
//
// import androidx.annotation.DrawableRes
// import androidx.compose.foundation.layout.fillMaxSize
// import androidx.compose.foundation.layout.padding
// import androidx.compose.foundation.text.BasicTextField
// import androidx.compose.runtime.Composable
// import androidx.compose.runtime.mutableStateOf
// import androidx.compose.runtime.remember
// import androidx.compose.ui.Modifier
// import androidx.compose.ui.tooling.preview.Preview
// import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
// import androidx.compose.ui.unit.dp
// import io.github.ch8n.compose97.R
// import io.github.ch8n.compose97.ui.components.windowscaffold.WindowScaffold
// import io.github.ch8n.compose97.ui.theme.notePadTextStyle
// import java.util.*
//
//
// data class Note(
//    val id: String = UUID.randomUUID().toString(),
//    val name: String,
//    val content: String,
// )
//
//
// @Composable
// fun NotePad(
//    title: String,
//    @DrawableRes icon: Int,
//    note: Note,
//    onTextChange: (content: String) -> Unit
// ) {
//    WindowScaffold(
//        title = title,
//        icon = icon
//    ) {
//        BasicTextField(
//            value = note.content,
//            onValueChange = onTextChange,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp),
//            textStyle = notePadTextStyle
//        )
//    }
// }
//
// @Preview
// @Composable
// fun RecycleBinPreview() {
//    val (dummyNote, setDummyNote) = remember {
//        mutableStateOf(
//            Note(name = "Sample", content = buildString {
//                append("hello")
//                append("\n")
//                append("World")
//                append("\n")
//                append(LoremIpsum(20).values.joinToString("\t"))
//            })
//        )
//    }
//    NotePad(
//        title = dummyNote.name,
//        icon = R.drawable.notepad_32x32,
//        note = dummyNote,
//        onTextChange = {
//            setDummyNote(dummyNote.copy(content = it))
//        }
//    )
// }
