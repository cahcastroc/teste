package br.edu.infnet.todo

data class ToDo(
    val title: String,
    val date: String,
    var isChecked: Boolean = false
)
