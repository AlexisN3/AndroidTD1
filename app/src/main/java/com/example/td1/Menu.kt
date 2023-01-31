package com.example.td1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.td1.databinding.ActivityMenuBinding
import com.example.td1.network.MenuResult
import com.example.td1.network.NetworkConstants
import com.google.gson.GsonBuilder
import org.json.JSONObject

enum class Category { STARTER, MAIN, DESSERTS }
class Menu : AppCompatActivity() {

    companion object {
        val extraKey = "extraKey"
    }
    lateinit var binding: ActivityMenuBinding
    lateinit var currentCategory: Category
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("lifeCycle", "Menu on Create")


        val category = intent.getSerializableExtra(extraKey) as? Category
        currentCategory = category ?: Category.STARTER

        supportActionBar?.title = categoryName()
        //showDatas()
        makeRequest()
    }

    private fun makeRequest(){
        val queue = Volley.newRequestQueue(this)
        val params = JSONObject()
        params.put(NetworkConstants.idShopKey, 1)
        val request =JsonObjectRequest(
                Method.POST,
                NetworkConstants.url,
                params,
                {
                    //sucess
                    Log.d("request", it.toString(2))
                    parseData(it.toString())
                },
                {
                    //error
                    Log.e("request", it.toString())
                }
        )
        queue.add(request)
    }
    private fun parseData(data: String) {
        val result = GsonBuilder().create().fromJson(data, MenuResult::class.java)
        val category = result.data.first {it.name == categoryFilterKey()}
        showDatas(category)
    }
    private fun showDatas(category: com.example.td1.network.Category) {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomAdapter(listOf("1", "2", "3")) {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }
    private fun categoryName(): String {
        return when (currentCategory) {
            Category.STARTER -> getString(R.string.starter)
            Category.MAIN -> getString(R.string.main)
            Category.DESSERTS -> getString(R.string.end)
        }
    }
    private fun categoryFilterKey(): String {
        return when (currentCategory) {
            Category.STARTER -> "Entrees"
            Category.MAIN -> "Plats"
            Category.DESSERTS -> "Desserts"
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
