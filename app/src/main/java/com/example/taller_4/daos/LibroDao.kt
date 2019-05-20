package com.example.taller_4.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4.entities.Libro

@Dao
interface LibroDao{
    @Query("SELECT * FROM libros")
    fun getAllBooks():LiveData<List<Libro>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(libro:Libro)

    @Query("DELETE FROM LIBROS")
    fun deleteTableLibro()
}