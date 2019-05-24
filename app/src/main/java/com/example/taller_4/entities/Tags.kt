package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "tags")
data class Tags(
    @ColumnInfo(name = "idTag")
    val idTag:String,
    @ColumnInfo(name = "tag")
    val tag:String
)