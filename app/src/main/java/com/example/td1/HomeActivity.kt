package com.example.td1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.td1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsListener()
    }
    private fun buttonsListener() {
        binding.starter.setOnClickListener {
            showCategory(Category.STARTER)
        }
        binding.main.setOnClickListener {
            showCategory(Category.MAIN)
        }
        binding.end.setOnClickListener {
            //Log.d("button", "Click sur button Desserts")
            //Toast.makeText(this, "Desserts", Toast.LENGTH_LONG).show()
            //val intent = Intent(this, Menu::class.java)
            //startActivity(intent)
            showCategory(Category.DESSERTS)

        }
    }
        private fun showCategory(category: Category){
            val intent = Intent(this, Menu::class.java)
            intent.putExtra(Menu.extraKey, category)
            startActivity(intent)
        }
}