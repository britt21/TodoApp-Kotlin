package com.example.advancetodo

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.advancetodo.databinding.FragmentUpdateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {


    val args by navArgs<UpdateFragmentArgs>()
    lateinit var binding: FragmentUpdateBinding
    lateinit var viewModel: TodoViewModel
    private val adapter = TodoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(inflater)

        binding.updatenameTxt.setText(args.updateArgs.Name)
        binding.updatesurnameTxt.setText(args.updateArgs.Surname)
        binding.updateageTxt.setText(args.updateArgs.age)

        viewModel.readTodo.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        binding.updateBtn.setOnClickListener {
            UpdateList()
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun UpdateList() {
        val name = binding.updatenameTxt.text.toString()
        val surname = binding.updatesurnameTxt.text.toString()
        val age = binding.updateageTxt.text.toString()

        if (name.isNotEmpty() && surname.isNotEmpty() && age.isNotEmpty()){
            val todo = Todos(args.updateArgs.id, name, surname, age)
            viewModel.Update(todo)
            findNavController().navigate(R.id.action_updateFragment_to_todoFragment)
            Toast.makeText(requireContext(), "Updated", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if (item.itemId == R.id.deleteall_item) {
           deleteTodo()

       }
        return super.onOptionsItemSelected(item)
            }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }



    fun deleteTodo(){

        val alertDialog = AlertDialog.Builder(requireContext())
            alertDialog.setPositiveButton("Yes"){_,_ ->
                viewModel.deleteTodo(args.updateArgs)
            }
        alertDialog.setNegativeButton("No"){_,_ ->}
        alertDialog.setMessage("Are you sure you want to delete this ${args.updateArgs.Name}?")
        alertDialog.setTitle("Delete ${args.updateArgs.Name}")
        alertDialog.create().show()
        findNavController().navigate(R.id.action_updateFragment_to_todoFragment)
    }


}



