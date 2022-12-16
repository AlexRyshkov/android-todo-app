package com.example.todoapp.todoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.Todo

class TodoAdapter(private val dataSet: List<Todo>) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView

        init {
            textViewName = view.findViewById(R.id.todo_name)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.todo_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val todo = dataSet[position]
        viewHolder.textViewName.text = todo.name;
    }

    override fun getItemCount() = dataSet.size

}