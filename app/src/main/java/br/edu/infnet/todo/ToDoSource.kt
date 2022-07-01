package br.edu.infnet.todo

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ToDoSource(
    private val todos: MutableList<ToDo>
) : RecyclerView.Adapter<ToDoSource.ToDoViewHolder>() {


    class ToDoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo_item,
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return todos.size
    }

    fun addItem(toDo: ToDo) {
        todos.add(toDo)
        notifyItemInserted(todos.size - 1)
    }
    fun deleteItem() {
        todos.removeAll { toDo ->
            toDo.isChecked
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val trendToDo = todos[position]

        holder.itemView.apply {

            val tvToDoTitle = findViewById<TextView>(R.id.tvToDoTitle)
                tvToDoTitle.text = trendToDo.title

            val tvToDoDate = findViewById<TextView>(R.id.tvToDoDate)
            tvToDoDate.text = trendToDo.date

            val cbChecked = findViewById<CheckBox>(R.id.cbChecked)
            cbChecked.isChecked = trendToDo.isChecked

            toggleStrikeThrough(tvToDoTitle, trendToDo.isChecked)
            cbChecked.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvToDoTitle, isChecked)
                trendToDo.isChecked = !trendToDo.isChecked
            }
        }
    }
}
private fun toggleStrikeThrough(tvToDoTitle: TextView, isChecked: Boolean) {
    if (isChecked) {
        tvToDoTitle.paintFlags = tvToDoTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        tvToDoTitle.paintFlags = tvToDoTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}


