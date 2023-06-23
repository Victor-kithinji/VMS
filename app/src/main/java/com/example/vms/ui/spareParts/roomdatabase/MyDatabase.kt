package com.example.addcart.roomdatabase

import android.arch.persistence.room.Database

@Database(entities=[Cart::class], version = 1)
abstract class MyDatabase {
    abstract fun cartDao():CartDao
}