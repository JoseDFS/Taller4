package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey @ColumnInfo(name = "Titulo") val titulo: String,
    @ColumnInfo (name = "Autor") val autores: String,
    @ColumnInfo (name = "Editorial") val editorial: String,
    @ColumnInfo (name = "Resumen") val resumen: String,
    @ColumnInfo (name = "Favorito") var favorito: Boolean,
    @ColumnInfo (name = "Caratula") val caratula: Int,
    @ColumnInfo (name = "Tags") val tags: String

    )