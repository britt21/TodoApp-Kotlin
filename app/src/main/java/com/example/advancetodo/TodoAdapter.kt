package com.example.advancetodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.DifferCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.advancetodo.databinding.ItemListBinding
import kotlinx.android.synthetic.main.item_list.view.*

class TodoAdapter : ListAdapter<Todos, TodoAdapter.TodoViewHolder>(DifferCallback) {
    class TodoViewHolder(val binding : ItemListBinding)  :RecyclerView.ViewHolder(binding.root) {

        fun bind(todos: Todos){
            binding.result = todos
        }

    }

    companion object DifferCallback : DiffUtil.ItemCallback<Todos>(){
        override fun areItemsTheSame(oldItem: Todos, newItem: Todos): Boolean {
            return  oldItem.Name === newItem.Name
        }

        override fun areContentsTheSame(oldItem: Todos, newItem: Todos): Boolean {
            return  oldItem.Name == oldItem.Name
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
     return TodoViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curlist = getItem(position)
    holder.bind(curlist)
        holder.itemView.row_layout.setOnClickListener {
            val action = TodoFragmentDirections.actionTodoFragmentToUpdateFragment(curlist)
            holder.itemView.findNavController().navigate(action)
        }

        }

    }

    var onClick : ((Todos) ->Unit)? = null

    fun Clicked(todos : (Todos) -> Unit){
        onClick = todos
    }
