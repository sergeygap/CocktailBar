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

    @Query("delete from cocktails where id = :id")
    fun deleteItem(id: Int)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCocktail(cocktail: Cocktails)

    @Query("SELECT COUNT(*) FROM cocktails")
    fun getRowCount(): Int

    @Query("SELECT * FROM cocktails WHERE id =:id")
    fun getCocktail(id: Int): Cocktails

}