package br.edu.infnet.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.navArgument
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var toDoSource: ToDoSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoSource = ToDoSource(mutableListOf())

        val userName = intent.getStringExtra("name")
        val textUserName = findViewById<TextView>(R.id.tvUserName)
        textUserName.text = "Hello, $userName"

        val rvToDoItems = findViewById<RecyclerView>(R.id.rvToDoItems)
        rvToDoItems.adapter = toDoSource
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        val current = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM")
        val toDoDate = current.format(formatter)

        val  btnAddItem = findViewById<Button>(R.id. btnAddItem)
        val etToDoTitle = findViewById<EditText>(R.id.etToDoTitle)
        val btnDelItem = findViewById<Button>(R.id.btnDelItem)

        btnAddItem.setOnClickListener {
            val toDoTitle = etToDoTitle.text.toString()
            if (toDoTitle.isNotEmpty()) {
                val toDo = ToDo(toDoTitle, toDoDate.toString())
                toDoSource.addItem(toDo)
                etToDoTitle.text.clear()
            }
        }
        btnDelItem.setOnClickListener {
            toDoSource.deleteItem()
        }

    }
}