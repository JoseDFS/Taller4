package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favoritos")
data class Favorito(
    @ColumnInfo(name = "Libros")
    val Libros:List<Libro>
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}