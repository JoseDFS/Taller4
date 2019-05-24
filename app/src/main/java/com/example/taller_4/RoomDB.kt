package com.example.taller_4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taller_4.daos.AutorDao
import com.example.taller_4.daos.FavoritosDao
import com.example.taller_4.daos.LibroDao
import com.example.taller_4.entities.Autor
import com.example.taller_4.entities.Favorito
import com.example.taller_4.entities.Libro

@Database(entities = [Libro::class,Favorito::class,Autor::class],version = 1,exportSchema = false)
public abstract class RoomDB:RoomDatabase(){
    abstract fun libroDao():LibroDao
    abstract fun favoritosDao():FavoritosDao
    abstract fun autorDao():AutorDao

    companion object {
        @Volatile
        private var INSTANCE:RoomDB?=null

        fun getInstance(context: Context):RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,RoomDB::class.java,"Database").build()
                INSTANCE = instance
                return instance
            }

        }
    }
}