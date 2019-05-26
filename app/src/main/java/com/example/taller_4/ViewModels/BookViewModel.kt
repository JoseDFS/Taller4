package com.example.taller_4.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller_4.Database.LibraryRoomDatabase
import com.example.taller_4.Repository.BookRepository
import com.example.taller_4.entities.Book
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<Book>>
    val allFavorite: LiveData<List<Book>>

    init {
        val wordsDao = LibraryRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = BookRepository(wordsDao)
        allWords = repository.allBooks
        allFavorite = repository.getFavorites
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }
}
