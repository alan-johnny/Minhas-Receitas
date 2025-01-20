package com.example.minhasreceitasapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.minhasreceitasapp.data.entity.Ingredient
import com.example.minhasreceitasapp.data.entity.PrepareMode
import com.example.minhasreceitasapp.data.entity.RecipeEntity

@Dao
interface RecipeDao  {
    @Query("Select * FROM recipe ")
    fun getAll() : List<RecipeEntity>

    @Insert
    fun insert(recipe: RecipeEntity)

    @Insert
    fun insert(ingredient: Ingredient)

    @Insert
    fun insert(prepareMode: PrepareMode)

    @Transaction
    @Query("SELECT * FROM recipe WHERE id = :recipeId")
    fun getRecipeWithIngredientsAndPrepareModes()
}