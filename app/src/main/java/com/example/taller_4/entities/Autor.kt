package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Autores")
data class Autor(
    @PrimaryKey(autoGenerate = true)
    var id_autor:Long,
    @ColumnInfo
    val nameAutor:String

)