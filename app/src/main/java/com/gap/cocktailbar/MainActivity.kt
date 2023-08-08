package com.gap.cocktailbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gap.cocktailbar.presentation.MyCocktailsEmptyFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (intent.getStringExtra(MODE) == MODE_EMPTY) {
//            launchFragment(MyCocktailsEmptyFragment())
//        } else if (intent.getStringExtra(MODE) == MODE_READY) {
//            launchFragment(MyCocktailsFragment())
//        }

        launchFragment(MyCocktailsEmptyFragment())

    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_fragment_container_view,
                fragment
            )
            .addToBackStack(null)
            .commit()
    }

    companion object {
        const val MODE_EMPTY = "mode_empty"
        const val MODE_READY = "mode_ready"
        const val MODE = "mode"
    }
}