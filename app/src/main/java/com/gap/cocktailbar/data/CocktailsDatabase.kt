package com.gap.cocktailbar.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cocktails::class], version = 1, exportSchema = false)
abstract class CocktailsDatabase : RoomDatabase() {
    abstract fun cocktailsDao(): CocktailsDao

    companion object {

        private var instance: CocktailsDatabase? = null
        private const val DB_NAME = "cocktails.db"

        fun getInstance(application: Application): CocktailsDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    application,
                    CocktailsDatabase::class.java,
                    DB_NAME
                )
                    .build()
            }

            return instance as CocktailsDatabase //
        }
    }

    fun isDatabaseEmpty(): Boolean {
        return cocktailsDao().getRowCount() == 0
    }
}


