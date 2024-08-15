package com.example.my_project.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_project.databinding.PopularItemBinding

class PopularAdapter(
    private val items: List<String>,
    private val prices: List<String>,
    private val images: List<Int>
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PopularItemBinding.inflate(inflater, parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(items[position], prices[position], images[position])
    }

    override fun getItemCount(): Int = items.size

    class PopularViewHolder(private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, price: String, image: Int) {
            binding.FoodName.text = item
            binding.price.text = price
            binding.imageView.setImageResource(image)
        }
    }
}
