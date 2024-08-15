package com.example.my_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_project.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding: ActivityPayOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding =ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.PlaceMyOrder.setOnClickListener {
            val bottomSheetDialog =CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}