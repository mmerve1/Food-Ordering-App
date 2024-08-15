package com.example.my_project.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.my_project.MenuBootomFragment
import com.example.my_project.R
import com.example.my_project.adaptor.PopularAdapter
import com.example.my_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // Argument işlemleri burada
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.ViewAllMenu.setOnClickListener {
            val bottomSheetDialog = MenuBootomFragment()  // MenuBootomFragment sınıfını çağırıyoruz
            bottomSheetDialog.show(parentFragmentManager, "Test")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val slideImageList = ArrayList<SlideModel>()
        slideImageList.add(SlideModel(R.drawable.plate, ScaleTypes.FIT))
        slideImageList.add(SlideModel(R.drawable.plate, ScaleTypes.FIT))
        slideImageList.add(SlideModel(R.drawable.plate, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(slideImageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                // İki tıklama işlemi burada ele alınacak
            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected image $position"
                Toast.makeText(context, itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val itemList = listOf("Pancake", "Burger", "Pizza", "Sandwich")
        val priceList = listOf("$5", "$6", "$7", "$8")
        val imageResourceList = listOf(R.drawable.pancake, R.drawable.burger, R.drawable.pizza, R.drawable.sandwich)

        val popularAdapter = PopularAdapter(itemList, priceList, imageResourceList)
        binding.popularRecycler.layoutManager = LinearLayoutManager(context)
        binding.popularRecycler.adapter = popularAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
