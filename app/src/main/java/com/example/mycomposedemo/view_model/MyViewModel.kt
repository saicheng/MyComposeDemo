package com.example.mycomposedemo.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mycomposedemo.model.MyItem

class MyViewModel: ViewModel() {
    var items by mutableStateOf(listOf<MyItem>())
     private set
    var curSearch by mutableStateOf<String>("")
    private lateinit var rawItems: List<MyItem>
    init {

        val list =  mutableListOf<MyItem>()
        list.add(MyItem("广东外语外贸大学本科招生网"))
        list.add(MyItem("2020年高考语文复习"))
        list.add(MyItem("普通高考--通知公告"))
        list.add(MyItem("中国书法高考网"))
        list.add(MyItem("高考信息网-高考最新信息"))
        list.add(MyItem("爱提提高考"))
        list.add(MyItem("高考语文试题"))
        list.add(MyItem("高考知识点_复习资料_考点解析_高考网"))
        list.add(MyItem("北京教育考试院"))
        list.add(MyItem("2021高考时间-2021年高考时间安排-高考时间表"))
        list.add(MyItem("高考家长必读"))
        list.add(MyItem("所有本科大学_本科高校名单汇总"))
        list.add(MyItem("高考改革"))
        list.add(MyItem("高考资源网"))
        list.add(MyItem("高考报名"))
        list.add(MyItem("高考资讯"))
        list.add(MyItem("招生考试信息网"))
        list.add(MyItem("高考食谱"))
        list.add(MyItem("福建高考试题"))

        this.rawItems = list.toList()
        this.items = this.items + this.rawItems
    }

    fun onTextChange(searchWord: String) {
        this.curSearch = searchWord

    }

    fun submit() {
        val theWord = this.curSearch
        this.curSearch = ""
        this.items = this.items.toMutableList().also {
            it.clear()
            val list =  if(theWord == "") {
                rawItems
            } else {
                rawItems.filter { item -> item.title.indexOf(theWord) >= 0}
            }
            it.addAll(list)
        }

    }
}