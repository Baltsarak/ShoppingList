package com.baltsarak.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.baltsarak.shoppinglist.data.ShopListRepositoryImpl
import com.baltsarak.shoppinglist.domain.DeleteShopItemUseCase
import com.baltsarak.shoppinglist.domain.EditShopItemUseCase
import com.baltsarak.shoppinglist.domain.GetShopItemListUseCase
import com.baltsarak.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemListUseCase = GetShopItemListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopItemListUseCase.getShopItemList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newShopItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newShopItem)
    }
}