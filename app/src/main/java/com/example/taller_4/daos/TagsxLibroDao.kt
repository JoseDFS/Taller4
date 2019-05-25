package com.example.taller_4.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4.entities.Tags

@Dao
interface TagsxLibroDao{

    @Query("SELECT * FROM TagsxLibro ")
    fun getAllTags():LiveData<List<Tags>>

    @Query("SELECT * FROM TagsxLibro WHERE idTag=:idTag")
    fun getAllBooksByTags(idTag: String):LiveData<List<Tags>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(idTag:String,idLibro:String)
}