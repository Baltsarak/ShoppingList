package com.baltsarak.shoppinglist.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.baltsarak.shoppinglist.R
import com.baltsarak.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
    }

    private fun setupRecyclerView() {
        val recyclerViewShopList = findViewById<RecyclerView>(R.id.recycler_view_shop_list)
        adapter = ShopListAdapter()
        recyclerViewShopList.adapter = adapter
    }
}