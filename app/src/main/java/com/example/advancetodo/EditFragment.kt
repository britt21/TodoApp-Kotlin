package com.example.advancetodo

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.advancetodo.databinding.FragmentEditBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EditFragment : Fragment() {


    lateinit var binding : FragmentEditBinding

    lateinit var viewModel : TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentEditBinding.inflate(inflater)


        binding.enterBtn.setOnClickListener {
            injectDatabase()

        }


        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

setHasOptionsMenu(true)
        return binding.root
    }



    private fun injectDatabase() {

        val Name = binding.nameTxt.text.toString()
        val surname = binding.surnameTxt.text.toString()
        val age = binding.ageTxt.text.toString()

        if(Name.isNotEmpty() && surname.isNotEmpty()&& age.isNotEmpty()){
            val todo = Todos(0,Name, surname, age)
            viewModel.Insert(todo)
            val action = EditFragmentDirections.actionEditFragmentToTodoFragment()
            findNavController().navigate(action)
            Toast.makeText(requireContext(), "Added data sussessfully", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(), "inseert some Text Bro!!!", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        MenuInflater(requireContext()).inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.deleteall_item ->{
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
