package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "TagsxLibro",foreignKeys = arrayOf(
    ForeignKey(entity = Libro::class,parentColumns = arrayOf("isbn"),childColumns = arrayOf("idLibro"),onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Tags::class,parentColumns = arrayOf("idTag"),childColumns = arrayOf("idTag"),onDelete = ForeignKey.CASCADE)
))
data class TagsxLibro(
    @ColumnInfo(name = "idTag")
    val idTag:String,
    @ColumnInfo(name = "idLibro")
    val idLibro:String
)