package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class Libro(

    @ColumnInfo(name = "titulo")
    val titulo:String,
    @ColumnInfo(name = "caratula")
    val caratula:String,
    @ColumnInfo(name = "autors")
    val autores:String,
    @ColumnInfo(name = "edicion")
    val edicion:String,
    @ColumnInfo(name = "editorial")
    val editorial:String,
    @ColumnInfo(name = "isbn")
    val isbn:String,
    @ColumnInfo(name = "resumen")
    val resumen:String,
    @ColumnInfo(name = "tags")
    val tags:List<String>
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}