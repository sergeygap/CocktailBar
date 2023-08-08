package com.gap.cocktailbar.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CocktailsDao {

    @Query("select * FROM cocktails")
    fun getCocktails(): LiveData<List<Cocktails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCocktail(cocktails: Cocktails)

    @Query("SELECT COUNT(*) FROM cocktails")
    fun getRowCount(): Int

}