package com.example.addcart.roomdatabase

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.vms.ui.spareParts.roomdatabase.Cart

@Dao
interface CartDao{
   @Insert
   fun addToCart(cart: Cart)

    @Query("SELECT * FROM MyCart")
    fun getCarts():List<Cart>

    @Query("SELECT EXISTS (SELECT 1 FROM MyCart WHERE id=:id)")
    fun isAddToCart(id:Int)

    @Query("select COUNT (*) from MyCart")
    fun countCart()
    @Query("DELETE FROM MyCart WHERE id=:id ")
    fun deleteItem(id:Int)

}