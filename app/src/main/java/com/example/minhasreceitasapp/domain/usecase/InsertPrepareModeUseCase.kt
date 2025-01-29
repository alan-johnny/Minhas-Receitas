package com.example.minhasreceitasapp.domain.usecase

import com.example.minhasreceitasapp.domain.model.PrepareModeDomain
import com.example.minhasreceitasapp.domain.repository.RecipeRepository

class InsertPrepareModeUseCase(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(prepareMode: PrepareModeDomain) =
        repository.insertPrepareMode(prepareMode)
}