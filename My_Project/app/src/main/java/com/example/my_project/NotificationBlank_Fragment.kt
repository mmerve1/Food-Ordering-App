package com.example.my_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_project.adapter.NotificationAdapter
import com.example.my_project.databinding.FragmentNotificationBlankBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList


class NotificationBlank_Fragment :BottomSheetDialogFragment() {
       private lateinit var binding :FragmentNotificationBlankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNotificationBlankBinding.inflate(layoutInflater,container,false)
        val notification = listOf("Your order has been Canceled Succesfully","Order has been taken by the driver","Congrats Your Order Placed ")
        val notificationimage= listOf(R.drawable.sademoji,R.drawable.car,R.drawable.checked)

           val adapter =NotificationAdapter(
               ArrayList(notification),
               ArrayList(notificationimage)

           )
        binding.notificationRecycleView.layoutManager =LinearLayoutManager(requireContext())
        binding.notificationRecycleView.adapter =adapter

            return binding.root
    }

    companion object {


    }
}