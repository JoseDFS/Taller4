package com.example.taller_4.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.taller_4.daos.LibroDao
import com.example.taller_4.entities.Libro

class WordRepository(private val libroDao: LibroDao) {

    val allBooks: LiveData<List<Libro>> = libroDao.getAllBooks()

    val deleteBooks = libroDao.deleteTableLibro()

    @WorkerThread
    suspend fun insert(libro: Libro) {
        libroDao.insert(libro)
    }
}