package com.example.mycomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposedemo.ui.theme.MyComposeDemoTheme
import com.example.mycomposedemo.view.MySearchView
import com.example.mycomposedemo.view_model.MyViewModel


class MainActivity : ComponentActivity() {
    val myViewModel by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                     MySearchView(myViewModel.curSearch,
                         myViewModel.items, onTextChange= myViewModel::onTextChange,
                         onSearch = myViewModel::submit)
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeDemoTheme {
        //MySearchView(dataList)
    }
}