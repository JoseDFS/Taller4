package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Autores")
data class Autor(
    @ColumnInfo
    val autor:String,
    @Relation(parentColumn = "id",entityColumn = "id")
    val libros:List<Libro>
){

        @PrimaryKey(autoGenerate = true)
        var id:Long=0

}