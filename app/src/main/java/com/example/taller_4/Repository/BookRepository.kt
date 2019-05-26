package com.example.taller_4.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.taller_4.daos.BookDao
import com.example.taller_4.entities.Book

class BookRepository(private var bookDao: BookDao) {

    val allBooks: LiveData<List<Book>> = bookDao.getBooks()

   val getFavorites:LiveData<List<Book>> = bookDao.getAllFavoriteBooks()

    @WorkerThread
    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }
    @WorkerThread
    suspend fun addFav(nameBook: String) {
        bookDao.addToFavarites(nameBook)
    }

    @WorkerThread
    suspend fun deleteFav(nameBook: String) {
        bookDao.removeFromFavarites(nameBook)
    }

}