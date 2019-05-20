package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Autores")
data class Autor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val autor:String
){

        @PrimaryKey(autoGenerate = true)
        var id:Long=0

}