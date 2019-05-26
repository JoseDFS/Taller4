package com.example.taller_4.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class LibroRepository(private val libroDao: LibroDao) {

    val allBooks: LiveData<List<Libro>> = libroDao.getAllBooks()

    val deleteBooks = libroDao.deleteTableLibro()

    @WorkerThread
    suspend fun insert(libro: Libro) {
        libroDao.insert(libro)
    }
}