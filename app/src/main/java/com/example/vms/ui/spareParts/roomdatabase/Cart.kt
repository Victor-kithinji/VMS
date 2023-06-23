package com.example.vms.ui.spareParts.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyCart")
data class Cart(
    @PrimaryKey(autoGenerate = true) var id:String,
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "imageId") var imageId:String,
    @ColumnInfo(name = "price") var price:String
)