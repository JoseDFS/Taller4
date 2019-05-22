package com.example.taller_4.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Translate")
data class Translate(

    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "cover")
    val cover:String,
    @Relation(parentColumn = "id",entityColumn = "id")
    val autors:List<Autor>,
    @ColumnInfo(name = "edition")
    val edition:String,
    @ColumnInfo(name = "editorial")
    val editorial:String,
    @ColumnInfo(name = "isbn")
    val isbn:String,
    @ColumnInfo(name = "resume")
    val resume:String,
    @ColumnInfo(name = "tags")
    val tags:List<String>
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}