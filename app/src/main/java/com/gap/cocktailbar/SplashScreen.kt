package com.gap.cocktailbar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gap.cocktailbar.MainActivity.Companion.MODE
import com.gap.cocktailbar.MainActivity.Companion.MODE_EMPTY
import com.gap.cocktailbar.MainActivity.Companion.MODE_READY
import com.gap.cocktailbar.data.CocktailsDatabase


@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)




        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
//        val database = CocktailsDatabase.getInstance(application)
//        val isDatabaseEmpty = database.isDatabaseEmpty()
        Handler(Looper.getMainLooper()).postDelayed({
//            var mode: String = if (isDatabaseEmpty) {
//                MODE_EMPTY
//            } else
//                MODE_READY

            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra(MODE, mode)
            startActivity(intent)

            finish()
        }, 1000)
    }



}