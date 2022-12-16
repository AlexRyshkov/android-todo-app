package com.example.todoapp.todoList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.data.Datasource
import com.example.todoapp.databinding.TodoListFragmentBinding

class TodoListFragment : Fragment() {

    private var _binding: TodoListFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TodoListFragmentBinding.inflate(inflater, container, false)
        val todos = Datasource.todos;
        val recyclerView = binding.recyclerView;
        recyclerView.adapter = TodoAdapter(todos);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_todoListFragment_to_addTodoFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}