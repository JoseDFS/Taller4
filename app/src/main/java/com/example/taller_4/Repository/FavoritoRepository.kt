package com.example.taller_4.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.taller_4.daos.FavoritosDao
import com.example.taller_4.daos.LibroDao
import com.example.taller_4.entities.Favorito
import com.example.taller_4.entities.Libro

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

}