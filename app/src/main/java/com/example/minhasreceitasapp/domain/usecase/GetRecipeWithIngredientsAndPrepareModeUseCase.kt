package com.example.minhasreceitasapp.domain.usecase

import com.example.minhasreceitasapp.domain.repository.RecipeRepository

class GetRecipeWithIngredientsAndPrepareModeUseCase (
    private val repository: RecipeRepository
){
    suspend operator fun invoke(idRecipe: Int) = repository.getRecipeWithIngredientsAndPrepareMode(idRecipe)
}