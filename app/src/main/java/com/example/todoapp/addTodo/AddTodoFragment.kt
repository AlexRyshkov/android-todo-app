package com.example.todoapp.addTodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.data.Datasource
import com.example.todoapp.data.Todo
import com.example.todoapp.databinding.AddTodoFragmentBinding

class AddTodoFragment : Fragment() {

    private var _binding: AddTodoFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = AddTodoFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAddTodo.setOnClickListener {
            val textViewName = binding.textviewName
            if (textViewName.text.isNotEmpty()) {
                val todo = Todo(textViewName.text.toString())
                Datasource.todos.add(todo)
                findNavController().navigate(R.id.todoListFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}