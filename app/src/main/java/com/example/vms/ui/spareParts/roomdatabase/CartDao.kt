package com.example.vms.ui.spareParts.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CartDao{

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun addToCart(cart: Cart)

    @Query("SELECT * FROM MyCart")
    fun getCarts(): Flow<List<Cart>>

    @Query("DELETE FROM MyCart WHERE id=:id ")
    fun deleteItem(id:Int)

}