package com.gap.cocktailbar.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CocktailsDao {

    @Query("select * FROM cocktails")
    fun getCocktails(): LiveData<List<Cocktails>>

    @Delete
    fun deleteItem(cocktail: Cocktails)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCocktail(cocktail: Cocktails)

    @Query("SELECT COUNT(*) FROM cocktails")
    fun getRowCount(): Int

    @Query("SELECT * FROM cocktails WHERE id =:id")
    fun getCocktail(id: Int): Cocktails

}