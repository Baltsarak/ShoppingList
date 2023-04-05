package com.baltsarak.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun getShopItem(shopItemId: Int): ShopItem

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItemList(): LiveData<List<ShopItem>>
}