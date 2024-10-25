package com.example.minhasreceitasapp.presentation.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.minhasreceitasapp.domain.usecase.GetAllRecipeUseCase
import com.example.minhasreceitasapp.domain.usecase.InsertRecipeUseCase

class RecipesViewModel(
    private val getAllRecipeUseCase: GetAllRecipeUseCase,
    private val insertRecipeUseCase: InsertRecipeUseCase
): ViewModel() {

}