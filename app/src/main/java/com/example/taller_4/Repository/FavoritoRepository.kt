/*package com.example.taller_4.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class FavoritoRepository(private val favoritoDao: FavoritosDao) {

    val allFavoritos: LiveData<List<Favorito>> = favoritoDao.getAllFavBooks()

    @WorkerThread
    suspend fun insertFavorite(libro: Libro) {
        favoritoDao.insertFavorite(libro)
    }
    @WorkerThread
    suspend  fun  deleteteFavorite(libro: Libro){
        favoritoDao.deleteFavorite(libro)
    }

}*/