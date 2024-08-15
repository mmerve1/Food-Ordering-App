package com.example.my_project.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_project.CongratsBottomSheet
import com.example.my_project.PayOutActivity
import com.example.my_project.R
import com.example.my_project.adapter.CartAdapter
import com.example.my_project.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartfoodname = listOf("burger", "sandwich", "pizza", "salad", "fries", "pancake")
        val cartitemprice = listOf("$4", "$4", "$4", "$4", "$4", "$4")
        val cartimage = listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.pizza,
            R.drawable.salad,
            R.drawable.fries,
            R.drawable.pancake
        )
        val adapter = CartAdapter(ArrayList(cartfoodname), ArrayList(cartitemprice), ArrayList(cartimage))
        binding.cardreycleview.layoutManager = LinearLayoutManager(requireContext())
        binding.cardreycleview.adapter = adapter
        binding.processButton.setOnClickListener{

            val intent = Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

    }
}
