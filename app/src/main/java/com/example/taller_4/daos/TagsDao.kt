package com.example.taller_4.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4.entities.Tags

@Dao
interface TagsDao{
    @Query("SELECT * FROM tags" )
    fun getAllTags():LiveData<List<Tags>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tags: Tags)

}