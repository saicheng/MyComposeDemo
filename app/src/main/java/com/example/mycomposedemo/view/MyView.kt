package com.example.mycomposedemo.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.mycomposedemo.model.MyItem

@Composable
fun MySearchView(text: String, items: List<MyItem>, onTextChange: (String) -> Unit,
                 onSearch: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        MyItemInput(text = text, onTextChange = onTextChange, submit = onSearch)
        LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.LightGray),
            contentPadding = PaddingValues(top = 10.dp)
            ) {
            items(items){ item ->
                MyItemView(item.title)
            }
        }

    }
}

@Composable
fun MyItemView(text: String) {
    Text(text = text , modifier = Modifier.padding(10.dp))
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyItemInput(text: String, onTextChange: (String) -> Unit, submit: () -> Unit) {
    val keywordController = LocalSoftwareKeyboardController.current
    Row(
        Modifier
            .padding(horizontal = 10.dp)
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                submit()
                keywordController?.hide()
            }),
            modifier = Modifier.weight(1.0f)
        )
        Button(onClick = {
            onTextChange("")
            submit()
            keywordController?.hide()
        }, modifier = Modifier.padding(4.dp)) {
            Text("重置")
        }
    }
}