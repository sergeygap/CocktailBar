package com.gap.cocktailbar.presentation.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gap.cocktailbar.data.Cocktails
import com.gap.cocktailbar.data.CocktailsDatabase
import kotlin.concurrent.thread

class DetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val db = CocktailsDatabase.getInstance(application)

    fun delete(id: Int) {
        thread {
            db.cocktailsDao().deleteItem(id)
        }
    }
}
