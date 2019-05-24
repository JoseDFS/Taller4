package com.example.taller_4.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taller_4.daos.AutorDao
import com.example.taller_4.daos.FavoritosDao
import com.example.taller_4.daos.LibroDao
import com.example.taller_4.entities.Autor
import com.example.taller_4.entities.Favorito
import com.example.taller_4.entities.Libro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Autor::class,Libro::class,Favorito::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase(){

    abstract fun bookDao() : LibroDao
    abstract fun authorDao() : AutorDao
    abstract fun favoriteDao() : FavoritosDao
    companion object {
        @Volatile
        private var INSTANCE : RoomDB? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Libro_DB")
                    .addCallback(DataBaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class DataBaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {


                }
            }
        }


    }
}