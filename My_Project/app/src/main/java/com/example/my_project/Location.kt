package com.example.my_project

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_project.databinding.ActivityLocationBinding

class Location : AppCompatActivity() {
    private val binding: ActivityLocationBinding by lazy {
        ActivityLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val locationList: Array<String> = arrayOf("Turkey", "France", "Spain", "India")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)

        val autoCompleteTextView: AutoCompleteTextView = binding.location
        autoCompleteTextView.setAdapter(adapter)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
