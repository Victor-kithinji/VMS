package com.example.vms.ui.spareParts.roomdatabase

import androidx.room.Database

@Database(entities=[Cart::class], version = 1)
abstract class MyDatabase {
    abstract fun cartDao(): CartDao
}