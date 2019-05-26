/*package com.example.taller_4.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class AutorRepository(private val autorDao: AutorDao) {

    val autor: LiveData<Autor> = autorDao.getOne()

    @WorkerThread
    suspend fun insertAutor(autor: Autor) {
        autorDao.insertAutor(autor)
    }


}*/