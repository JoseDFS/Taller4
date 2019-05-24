package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "libros")
data class Libro(

    @ColumnInfo(name = "titulo")
    val titulo:String,
    @ColumnInfo(name = "caratula")
    val caratula:String,
    @Relation(parentColumn = "id",entityColumn = "id")
    val autores: String,
    @ColumnInfo(name = "edicion")
    val edicion:String,
    @ColumnInfo(name = "editorial")
    val editorial:String,
    @ColumnInfo(name = "isbn")
    val isbn:String,
    @ColumnInfo(name = "resumen")
    val resumen:String,
    @ColumnInfo(name = "tags")
    val tags: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}