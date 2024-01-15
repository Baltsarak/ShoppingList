package com.baltsarak.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baltsarak.shoppinglist.domain.DeleteShopItemUseCase
import com.baltsarak.shoppinglist.domain.EditShopItemUseCase
import com.baltsarak.shoppinglist.domain.GetShopItemListUseCase
import com.baltsarak.shoppinglist.domain.ShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getShopItemListUseCase: GetShopItemListUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase,
    private val editShopItemUseCase: EditShopItemUseCase
) : ViewModel() {

    val shopList = getShopItemListUseCase.getShopItemList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newShopItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newShopItem)
        }
    }
}