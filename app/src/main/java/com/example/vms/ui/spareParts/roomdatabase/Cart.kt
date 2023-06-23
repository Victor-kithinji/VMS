package com.example.vms.ui.spareParts.roomdatabase

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.OnConflictStrategy

import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "MyCart")
data class Cart(
    @PrimaryKey(autoGenerate = true) var id:String,
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "imageId") var imageId:String,
    @ColumnInfo(name = "price") var price:String
)