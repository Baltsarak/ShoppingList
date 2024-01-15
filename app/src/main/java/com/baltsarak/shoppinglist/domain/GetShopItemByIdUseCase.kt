package com.baltsarak.shoppinglist.domain

import javax.inject.Inject

class GetShopItemByIdUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    suspend fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}