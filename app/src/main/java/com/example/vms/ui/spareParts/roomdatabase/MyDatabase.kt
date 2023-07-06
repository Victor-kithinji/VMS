package com.example.vms.ui.spareParts.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=[Cart::class], version = 2)
abstract class MyDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao

    /**
    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context) : MyDatabase {
            return INSTANCE?: synchronized(this) {
                val db = Room.databaseBuilder(context.applicationContext,MyDatabase::class.java,"my-db")
                    .build()

                INSTANCE = db
                db
            }
        }
     }
**/

    }
