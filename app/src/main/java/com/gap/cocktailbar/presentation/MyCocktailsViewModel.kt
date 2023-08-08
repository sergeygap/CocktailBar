package com.gap.cocktailbar.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gap.cocktailbar.data.CocktailsDatabase
import com.gap.cocktailbar.data.Cocktails

class MyCocktailsViewModel(application: Application) : AndroidViewModel(application) {

    private var cocktailsDatabase: CocktailsDatabase

    init {
        cocktailsDatabase = CocktailsDatabase.getInstance(application)
    }

    fun getCocktails(): LiveData<List<Cocktails>>{
        return cocktailsDatabase.cocktailsDao().getCocktails()
    }

}