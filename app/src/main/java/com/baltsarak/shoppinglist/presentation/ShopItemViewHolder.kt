package com.baltsarak.shoppinglist.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baltsarak.shoppinglist.R

class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val textViewName = view.findViewById<TextView>(R.id.text_view_name)
    val textViewCount = view.findViewById<TextView>(R.id.text_view_count)
}