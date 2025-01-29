package com.example.minhasreceitasapp.domain.usecase

import com.example.minhasreceitasapp.domain.model.IngredientDomain
import com.example.minhasreceitasapp.domain.repository.RecipeRepository

class InsertIngredientsUseCase (
    private val repository: RecipeRepository
){
    suspend operator fun invoke(ingredientDomain: IngredientDomain) =
        repository.insertIngredient(ingredientDomain)
}