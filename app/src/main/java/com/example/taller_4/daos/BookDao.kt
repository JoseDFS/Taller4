package com.example.taller_4.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4.entities.Book

@Dao
interface BookDao{
    @Query("SELECT * FROM book_table ORDER BY Titulo ASC")
    fun getBooks():LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Book)

    @Query("DELETE FROM book_table")
    suspend fun deleteAllBooks()

    @Query("SELECT * FROM book_table WHERE Favorito")
    fun getAllFavoriteBooks():LiveData<List<Book>>

}