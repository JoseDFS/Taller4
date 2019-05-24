package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "libroxautor",foreignKeys = arrayOf(
    ForeignKey(entity = Libro::class,parentColumns = arrayOf("isbn"),childColumns = arrayOf("idLibro"),onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Autor::class,parentColumns = arrayOf("id_autor"),childColumns = arrayOf("idAutor"),onDelete = ForeignKey.CASCADE)
)
)

data class LibroxAutor(
    @ColumnInfo(name = "idLibro")
    val idLibro:String,
    @ColumnInfo(name = "idAutor")
    val idAutor:String
)