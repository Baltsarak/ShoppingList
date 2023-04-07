package com.baltsarak.shoppinglist.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.baltsarak.shoppinglist.R
import com.baltsarak.shoppinglist.domain.ShopItem

class ShopListAdapter : Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = listOf<ShopItem>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_shop_enabled, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        viewHolder.textViewName.text = shopItem.name
        viewHolder.textViewCount.text = shopItem.count.toString()
        viewHolder.view.setOnLongClickListener {
            true
        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    class ShopItemViewHolder(val view: View) : ViewHolder(view) {
        val textViewName = view.findViewById<TextView>(R.id.text_view_name)
        val textViewCount = view.findViewById<TextView>(R.id.text_view_count)
    }
}