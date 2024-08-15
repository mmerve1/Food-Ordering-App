package com.example.my_project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Splash : AppCompatActivity() {
    //oncreat activity olustugunda cagrılır.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //düzenlenen activity.splash dosaysını düzenler ve cagırır.
        setContentView(R.layout.activity_splash)//bu dosya acılıyor

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Add a delay before starting MainActivity
        //bekleme loopu
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Start::class.java)
            //Intent bir android sınıfıdır.sınıflar arasında geçiş yapmak için kullanılır.
            startActivity(intent)
            //startActivity de bir android sınıfıdır.intenti yani oradaki sınıfı başlatmak için kullanılır
            finish()
        }, 3000) // 3000 milliseconds delay
    }
}
