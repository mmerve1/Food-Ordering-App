package com.example.my_project.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_project.R
import com.example.my_project.adapter.MenuAdapter
import com.example.my_project.databinding.FragmentSearchBinding
import androidx.appcompat.widget.SearchView

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private val originalFoodName = listOf("burger", "sandwich", "pizza", "salad", "fries", "pancake")
    private val originalPrice = listOf("$4", "$4", "$4", "$4", "$4", "$4")
    private val originalMenuImage = listOf(
        R.drawable.burger,
        R.drawable.sandwich,
        R.drawable.pizza,
        R.drawable.salad,
        R.drawable.fries,
        R.drawable.pancake
    )

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        // Adapter ve RecyclerView ayarları
        adapter = MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage)
        binding.AllMenuRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.AllMenuRecycleView.adapter = adapter

        // Arama işlevini ayarla
        setupSearchView()

        // Tüm menüyü göster
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalFoodName)
        filteredMenuItemPrice.addAll(originalPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        // Arama kutusu dinleyicisini ayarla
        binding.searchView.setOnQueryTextListener(
            /* listener = */
            object : SearchView.OnQueryTextListener, android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    filterMenuItem(query)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filterMenuItem(newText)
                    return true
                }
            },
        )
    }

    private fun filterMenuItem(query: String?) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        if (query.isNullOrEmpty()) {
            // Arama boşsa tüm menüyü göster
            showAllMenu()
        } else {
            // Arama terimini filtrele
            originalFoodName.forEachIndexed { index, foodName ->
                if (foodName.contains(query, ignoreCase = true)) {
                    filteredMenuFoodName.add(foodName)
                    filteredMenuItemPrice.add(originalPrice[index])
                    filteredMenuImage.add(originalMenuImage[index])
                }
            }
        }
        adapter.notifyDataSetChanged()
    }
}
