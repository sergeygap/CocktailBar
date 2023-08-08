package com.gap.cocktailbar.presentation.edit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gap.cocktailbar.data.Cocktails
import com.gap.cocktailbar.data.CocktailsDatabase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlin.concurrent.thread

class EditViewModel(application: Application) : AndroidViewModel(application) {

    private val db = CocktailsDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    fun addCocktails(cocktails: Cocktails) {

        thread {
            db.cocktailsDao().addCocktail(cocktails)
        }

    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}