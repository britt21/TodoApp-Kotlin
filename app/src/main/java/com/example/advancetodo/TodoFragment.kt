package com.example.advancetodo

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.advancetodo.databinding.FragmentTodoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoFragment : Fragment() {

    val args = navArgs<UpdateFragmentArgs>()

    lateinit var todoViewModel: TodoViewModel
    private val adapter = TodoAdapter()
    lateinit var binding : FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
binding = FragmentTodoBinding.inflate(inflater)


        binding.floatBtn.setOnClickListener {
            findNavController().navigate(R.id.action_todoFragment_to_editFragment)
        }

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        binding.rvList.adapter = adapter
        todoViewModel.readTodo.observe(viewLifecycleOwner, Observer { user ->
            adapter.submitList(user)
        })

        setHasOptionsMenu(true)


        return binding.root
    }



}