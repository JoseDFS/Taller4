package com.example.taller_4.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller_4.entities.Favorito
import com.example.taller_4.entities.Libro

@Dao
interface FavoritosDao{
    @Query("SELECT * FROM Favoritos")
    fun getAllFavBooks():LiveData<List<Favorito>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(libro: Libro)

    @Query("DELETE FROM Favoritos")
    fun deleteFavorite(libro: Libro)

}