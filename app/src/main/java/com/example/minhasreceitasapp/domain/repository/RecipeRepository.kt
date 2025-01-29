package com.example.minhasreceitasapp.domain.repository

import com.example.minhasreceitasapp.domain.model.FullRecipeDomain
import com.example.minhasreceitasapp.domain.model.IngredientDomain
import com.example.minhasreceitasapp.domain.model.PrepareModeDomain
import com.example.minhasreceitasapp.domain.model.RecipeDomain

interface RecipeRepository {
    suspend fun getAll(): List<RecipeDomain>
    suspend fun insert(recipe: RecipeDomain)
    suspend fun getRecipeWithIngredientsAndPrepareMode(idRecipe: Int): FullRecipeDomain
    suspend fun insertIngredient(ingredient: IngredientDomain)
    suspend fun insertPrepareMode(prepareMode: PrepareModeDomain)
    suspend fun updateIngredient(ingredient: IngredientDomain)
    suspend fun updatePrepareMode(prepareMode: PrepareModeDomain)
}