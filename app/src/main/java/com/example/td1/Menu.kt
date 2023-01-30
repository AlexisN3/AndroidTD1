package com.example.td1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.td1.databinding.ActivityMenuBinding

enum class Category { STARTER, MAIN, DESSERTS }
class Menu : AppCompatActivity() {

    companion object {
        val extraKey = "extraKey"
    }
    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("lifeCycle", "Menu on Create")


        val category = intent.getSerializableExtra(extraKey) as? Category

        supportActionBar?.title = categoryName(category ?: Category.STARTER)
    }
    private fun categoryName(category: Category): String {
        return when(category){
            Category.STARTER -> getString(R.string.starter)
            Category.MAIN -> getString(R.string.main)
            Category.DESSERTS -> getString(R.string.end)
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "Menu on Start")

    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "Menu on Resume")

    }
}
