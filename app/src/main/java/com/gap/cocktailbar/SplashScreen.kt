package com.gap.cocktailbar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.gap.cocktailbar.MainActivity.Companion.MODE
import com.gap.cocktailbar.MainActivity.Companion.MODE_EMPTY
import com.gap.cocktailbar.MainActivity.Companion.MODE_READY
import com.gap.cocktailbar.data.CocktailsDatabase
import java.util.concurrent.CountDownLatch
import kotlin.concurrent.thread


@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {

    private lateinit var db: CocktailsDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        db = CocktailsDatabase.getInstance(this)



        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val latch = CountDownLatch(1)
        var isDatabaseEmpty = false

        thread {
            isDatabaseEmpty = db.isDatabaseEmpty()
            latch.countDown()
        }

        latch.await() // Ожидание завершения потока

        Log.d("Test", isDatabaseEmpty.toString())
        Handler(Looper.getMainLooper()).postDelayed({
            val mode: String = if (isDatabaseEmpty) {
                MODE_EMPTY
            } else
                MODE_READY

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MODE, mode)
            startActivity(intent)

            finish()
        }, 1000)
    }


}