package com.gap.cocktailbar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cocktails::class], version = 1, exportSchema = false)
abstract class CocktailsDatabase : RoomDatabase() {
    abstract fun cocktailsDao(): CocktailsDao


    companion object {

        private var db: CocktailsDatabase? = null
        private const val DB_NAME = "cocktails.db"
        private val LOCK = Any()

        fun getInstance(context: Context): CocktailsDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    CocktailsDatabase::class.java,
                    DB_NAME
                ).build()
                db = instance
                return instance
            }
        }
    }

    fun isDatabaseEmpty(): Boolean {
        return cocktailsDao().getRowCount() == 0
    }
}


