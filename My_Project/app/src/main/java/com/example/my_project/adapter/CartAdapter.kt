package com.example.my_project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_project.databinding.CardItemBinding

class CartAdapter(
    private val cartitems: MutableList<String>,
    private val cartpriceitem: MutableList<String>,
    private val Cartimage: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CardViewHolder>() {

    private val itemquantity = IntArray(cartitems.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartitems.size

    inner class CardViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemquantity[position]
                cardfoodname.text = cartitems[position]
                carditemprice.text = cartpriceitem[position]
                cardimage.setImageResource(Cartimage[position])
                cardquantity.text = quantity.toString()

                minusbutton.setOnClickListener {
                    decreaseQuantity(position)
                }

                plusbutton.setOnClickListener {
                    increaseQuantity(position)
                }

                deletebutton.setOnClickListener {
                    val itemposition = adapterPosition
                    if (itemposition != RecyclerView.NO_POSITION) {
                        deleteItem(itemposition)
                    }
                }
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemquantity[position] > 1) {
                itemquantity[position]--
                binding.cardquantity.text = itemquantity[position].toString()
            }
        }

        private fun increaseQuantity(position: Int) {
            if (itemquantity[position] < 10) {
                itemquantity[position]++
                binding.cardquantity.text = itemquantity[position].toString()
            }
        }

        private fun deleteItem(position: Int) {
            cartitems.removeAt(position)
            Cartimage.removeAt(position)
            cartpriceitem.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartitems.size)
        }
    }
}
