package com.example.taller_4.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4.entities.Libro
import com.example.taller_4.entities.Translate

@Dao
interface TranslateDao{
    @Query("SELECT * FROM translate")
    fun getAllBooksTranslate(): LiveData<List<Libro>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTranslatedBook(bookTranslate: Translate)

    @Query("DELETE FROM libros")
    fun deleteTranslatedBook()

}