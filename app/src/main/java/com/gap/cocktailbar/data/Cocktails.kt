package com.gap.cocktailbar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class Cocktails(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    val listIngredients: String? = null,
    val recipe: String? = null
)