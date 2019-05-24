package com.example.taller_4.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller_4.Repository.FavoritoRepository
import com.example.taller_4.Repository.LibroRepository
import com.example.taller_4.entities.Autor
import com.example.taller_4.entities.Libro
import com.example.taller_4.entities.Favorito
import com.example.taller_4.Room.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application){
    private val repository : LibroRepository
    private val repository2 : FavoritoRepository

    init {
        val booksDao = RoomDB.getInstance(application,viewModelScope).bookDao()
        val authorsDao = RoomDB.getInstance(application,viewModelScope).authorDao()
        val favoriteDao = RoomDB.getInstance(application,viewModelScope).favoriteDao()
        repository = LibroRepository(booksDao)
        repository2 = FavoritoRepository(favoriteDao)


    }


    fun allBooks() = repository.allBooks




    //Funciones de Book


    // Funciones de insertar

    fun insertBook(book : Libro) = viewModelScope.launch ( Dispatchers.IO ){
        repository.insert(book)
    }



}