package com.example.taller_4.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4.entities.Autor

@Dao
interface AutorDao{

    @Query("SELECT * FROM Autores")
    fun getOne():LiveData<Autor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAutor(autor: Autor)
}