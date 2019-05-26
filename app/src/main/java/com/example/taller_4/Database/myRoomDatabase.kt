package com.example.taller_4.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taller_4.R
import com.example.taller_4.daos.BookDao
import com.example.taller_4.entities.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Book::class],version = 6)
abstract class myRoomDatabase: RoomDatabase(){
    abstract fun bookDao():BookDao

    companion object {
        @Volatile
        private var INSTANCE: myRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): myRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE
                ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        myRoomDatabase::class.java,
                        "word_database"
                    )
                        // Wipes and rebuilds instead of migrating if no Migration object.
                        // Migration is not part of this codelab.
                        .fallbackToDestructiveMigration()
                        .addCallback(WordDatabaseCallback(scope))
                        .build()
                    INSTANCE = instance
                    // return instance
                    instance
                }
        }

        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.bookDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(bookDao: BookDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            //bookDao.deleteAll()
            val True:Boolean = true
            val False:Boolean = false

            var word = Book("Harry Potter y la piedra filosofal", "J.K Rowling", "Editorial Salamandra", "Harry Potter y la piedra filosofal es el primer libro de una serie de siete, fue publicado en el Reino Unido el 30 de junio de 1997 y en español en marzo de 1999.\n" +
                    "\n" +
                    "Se trata de uno de los libros más vendidos de la historia, las estimaciones de sus ventas mundiales superan los 110 millones de copias.\n" +
                    "\n" +
                    "Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley.", true, R.drawable.harry)
            bookDao.insert(word)

            word = Book("Harry Potter y la camara secreta", "J.K Rowling", "Editorial Salamandra", "Harry Potter y la piedra filosofal es el primer libro de una serie de siete, fue publicado en el Reino Unido el 30 de junio de 1997 y en español en marzo de 1999.\n" +
                    "\n" +
                    "Se trata de uno de los libros más vendidos de la historia, las estimaciones de sus ventas mundiales superan los 110 millones de copias.\n" +
                    "\n" +
                    "Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley.", false, R.drawable.harry2)

            bookDao.insert(word)

            word = Book("Harry Potter y el prisionero de Askaban", "J.K Rowling", "Editorial Salamandra", "Harry Potter y la piedra filosofal es el primer libro de una serie de siete, fue publicado en el Reino Unido el 30 de junio de 1997 y en español en marzo de 1999.\n" +
                    "\n" +
                    "Se trata de uno de los libros más vendidos de la historia, las estimaciones de sus ventas mundiales superan los 110 millones de copias.\n" +
                    "\n" +
                    "Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley.", true, R.drawable.harry3)
            bookDao.insert(word)

            word = Book("Harry Potter y el caliz de fuego", "J.K Rowling", "Editorial Salamandra", "Harry Potter y la piedra filosofal es el primer libro de una serie de siete, fue publicado en el Reino Unido el 30 de junio de 1997 y en español en marzo de 1999.\n" +
                    "\n" +
                    "Se trata de uno de los libros más vendidos de la historia, las estimaciones de sus ventas mundiales superan los 110 millones de copias.\n" +
                    "\n" +
                    "Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley.", false, R.drawable.harry4)

            bookDao.insert(word)

            word = Book("Harry Potter y la orden del fenix", "J.K Rowling", "Editorial Salamandra", "Harry Potter y la piedra filosofal es el primer libro de una serie de siete, fue publicado en el Reino Unido el 30 de junio de 1997 y en español en marzo de 1999.\n" +
                    "\n" +
                    "Se trata de uno de los libros más vendidos de la historia, las estimaciones de sus ventas mundiales superan los 110 millones de copias.\n" +
                    "\n" +
                    "Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley.", true, R.drawable.harry5)
            bookDao.insert(word)

            word = Book("Harry Potter y el principe mestizo", "J.K Rowling", "Editorial Salamandra", "Harry Potter y la piedra filosofal es el primer libro de una serie de siete, fue publicado en el Reino Unido el 30 de junio de 1997 y en español en marzo de 1999.\n" +
                    "\n" +
                    "Se trata de uno de los libros más vendidos de la historia, las estimaciones de sus ventas mundiales superan los 110 millones de copias.\n" +
                    "\n" +
                    "Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley.", false, R.drawable.harry6)

            bookDao.insert(word)

            word = Book("Harry Potter y las reliquias de la muerte", "J.K Rowling", "Editorial Salamandra", "Harry Potter y la piedra filosofal es el primer libro de una serie de siete, fue publicado en el Reino Unido el 30 de junio de 1997 y en español en marzo de 1999.\n" +
                    "\n" +
                    "Se trata de uno de los libros más vendidos de la historia, las estimaciones de sus ventas mundiales superan los 110 millones de copias.\n" +
                    "\n" +
                    "Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley.", true, R.drawable.harry7)

            bookDao.insert(word)

        }
    }

}