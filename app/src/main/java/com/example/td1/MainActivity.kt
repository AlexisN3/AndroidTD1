package com.example.td1

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.td1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsListener()
    }
    private fun buttonsListener() {
        binding.starter.setOnClickListener{
            Log.d("button", "Click sur button Entrees")
            Toast.makeText(this, "Entrees", Toast.LENGTH_LONG).show()
        }
        binding.main.setOnClickListener{
            Log.d("button", "Click sur button Plats")
        }
        binding.end.setOnClickListener{
            Log.d("button", "Click sur button Desserts")
        }
    }
}