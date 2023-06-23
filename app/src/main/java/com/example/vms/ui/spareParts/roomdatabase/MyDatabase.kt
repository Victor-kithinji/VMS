package com.example.vms.ui.spareParts.roomdatabase

import android.arch.persistence.room.Database
import com.example.addcart.roomdatabase.CartDao
import com.example.vms.ui.spareParts.roomdatabase.Cart

@Database(entities=[Cart::class], version = 1)
abstract class MyDatabase {
    abstract fun cartDao(): CartDao
}