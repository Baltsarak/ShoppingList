package com.baltsarak.shoppinglist.di

import android.app.Application
import com.baltsarak.shoppinglist.data.AppDatabase
import com.baltsarak.shoppinglist.data.ShopListDao
import com.baltsarak.shoppinglist.data.ShopListRepositoryImpl
import com.baltsarak.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideShopListDao(application: Application): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}