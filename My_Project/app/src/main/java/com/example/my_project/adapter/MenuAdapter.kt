package com.example.my_project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_project.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItemName: MutableList<String>,
    private val menuItemPrice: MutableList<String>,
    private val menuImage: MutableList<Int>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                MenuFoodName.text = menuItemName[position]
                menuprice.text = menuItemPrice[position]
                menuimage.setImageResource(menuImage[position])
            }
        }
    }
}
