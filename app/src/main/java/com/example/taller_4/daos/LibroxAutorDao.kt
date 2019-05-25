package com.example.taller_4.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4.entities.Libro

@Dao
interface LibroxAutorDao{

    @Query("SELECT * FROM LIBROXAUTOR WHERE idAutor=:idAutor")
    fun getAllBooksByAutor(idAutor: String): LiveData<List<Libro>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(idLibro:String,idAutor: String)


}