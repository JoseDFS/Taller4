package com.example.taller_4.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller_4.Database.myRoomDatabase
import com.example.taller_4.Repository.AutorRepository
import com.example.taller_4.Repository.FavoritoRepository
import com.example.taller_4.Repository.LibroRepository
import com.example.taller_4.entities.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application) {

    private val repository: LibroRepository

    val allBooks: LiveData<List<Book>>
    val allFavorite: LiveData<List<Book>>

    init {
        val booksDao = myRoomDatabase.getDatabase(application, viewModelScope).bookDao()
        repository = LibroRepository(booksDao)
        allBooks = repository.allBooks
        allFavorite = repository.getFavorites
    }

    fun insert(book: Book) = viewModelScope.launch{
        repository.insert(book)
    }

}