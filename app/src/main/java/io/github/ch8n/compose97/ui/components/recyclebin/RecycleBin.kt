//package io.github.ch8n.compose97.ui.components.recyclebin
//
//import androidx.annotation.DrawableRes
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import io.github.ch8n.compose97.R
//import io.github.ch8n.compose97.ui.components.windowscaffold.WindowScaffold
//import java.util.*
//
//
//private val dummyNotes = listOf(
//    NoteItem(name = "test1"),
//    NoteItem(name = "test1"),
//    NoteItem(name = "test1"),
//)
//
//data class NoteItem(
//    val id: String = UUID.randomUUID().toString(),
//    val name: String
//)
//
//@Composable
//fun RecycleBin(
//    title: String,
//    @DrawableRes icon: Int
//) {
//    WindowScaffold(
//        title = title,
//        icon = icon
//    ) {
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(
//                    vertical = 8.dp
//                )
//        ) {
//            items(dummyNotes) { item: NoteItem ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    repeat(5) {
//                        NoteItemUi(item)
//                        Spacer(modifier = Modifier.width(8.dp))
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun NoteItemUi(item: NoteItem) {
//    Column() {
//        Icon(
//            painter = painterResource(id = R.drawable.notepad_file_32x32),
//            contentDescription = "",
//            tint = Color.Unspecified,
//            modifier = Modifier.size(36.dp)
//        )
//        Text(text = item.name)
//    }
//}
//
//@Preview
//@Composable
//fun RecycleBinPreview() {
//    RecycleBin(
//        title = """RecycleBin""",
//        icon = R.drawable.recycle_bin_32x32
//    )
//}