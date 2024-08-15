package com.example.my_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_project.adapter.MenuAdapter
import com.example.my_project.databinding.FragmentMenuBootomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBootomFragment : BottomSheetDialogFragment(){
    private lateinit var binding:FragmentMenuBootomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMenuBootomBinding.inflate(inflater,container,false)

        //setOncLick ile basılabilir hale getirdik ve fonksiyon ekledik.
        binding.buttonBack.setOnClickListener {
            //dismiss bu fragment i kapatmak için kullanılır.
            dismiss()
        }

        val menufoodname = listOf("burger", "sandwich", "pizza", "salad", "fries", "pancake","burger", "sandwich", "pizza", "salad", "fries", "pancake")
        val menuitemprice = listOf("$4", "$4", "$4", "$4", "$4", "$4","$4", "$4", "$4", "$4", "$4", "$4")
        val menuimage = listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.pizza,
            R.drawable.salad,
            R.drawable.fries,
            R.drawable.pancake,
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.pizza,
            R.drawable.salad,
            R.drawable.fries,
            R.drawable.pancake
        )

        val adapter = MenuAdapter(ArrayList(menufoodname), ArrayList(menuitemprice), ArrayList(menuimage))
        binding.AllMenuRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.AllMenuRecycleView.adapter = adapter

        return binding.root

    }

    companion object {


    }
}