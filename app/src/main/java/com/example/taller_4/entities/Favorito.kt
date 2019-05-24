package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Favoritos")
data class Favorito(
    @Relation(parentColumn = "id",entityColumn = "id")
    val Libros:List<Libro>
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}