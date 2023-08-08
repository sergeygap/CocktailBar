package com.gap.cocktailbar.presentation.cocktails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gap.cocktailbar.data.CocktailsDatabase
import com.gap.cocktailbar.data.Cocktails
import kotlin.concurrent.thread

class MyCocktailsViewModel(application: Application) : AndroidViewModel(application) {

    private var db: CocktailsDatabase = CocktailsDatabase.getInstance(application)


    fun getCocktails(): LiveData<List<Cocktails>>{
        return db.cocktailsDao().getCocktails()
    }

}