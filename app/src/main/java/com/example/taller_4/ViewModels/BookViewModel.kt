package com.example.taller_4.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller_4.Repository.AutorRepository
import com.example.taller_4.Repository.FavoritoRepository
import com.example.taller_4.Repository.LibroRepository
import com.example.taller_4.RoomDB
import com.example.taller_4.entities.Autor
import com.example.taller_4.entities.Favorito
import com.example.taller_4.entities.Libro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application) {

    private val libroRepository: LibroRepository
    private val favoritoRepository: FavoritoRepository
    private val autorRepository: AutorRepository
    val allLibros: LiveData<List<Libro>>
    val allFavoritos: LiveData<List<Favorito>>
    val allAutor: LiveData<Autor>

    init {
        val librosDao = RoomDB.getInstance(application).libroDao()
        val favoritosDao = RoomDB.getInstance(application).favoritosDao()
        val autoresDao = RoomDB.getInstance(application).autorDao()
        libroRepository = LibroRepository(librosDao)
        favoritoRepository = FavoritoRepository(favoritosDao)
        autorRepository = AutorRepository(autoresDao)
        allLibros = libroRepository.allBooks
        allFavoritos = favoritoRepository.allFavoritos
        allAutor = autorRepository.autor
    }

    fun insertLibro(libro: Libro) = viewModelScope.launch(Dispatchers.IO){
        libroRepository.insert(libro)
    }

    fun insertAutor(autor: Autor) = viewModelScope.launch(Dispatchers.IO){
        autorRepository.insertAutor(autor)
    }

    fun insertFavorito(favorito: Libro) = viewModelScope.launch(Dispatchers.IO){
        favoritoRepository.insertFavorite(favorito)
    }
}