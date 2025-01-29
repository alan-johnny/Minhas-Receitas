package com.example.minhasreceitasapp.data.repository

import com.example.minhasreceitasapp.data.dao.RecipeDao
import com.example.minhasreceitasapp.data.entity.Ingredient
import com.example.minhasreceitasapp.data.mapper.toDomain
import com.example.minhasreceitasapp.data.mapper.toEntity
import com.example.minhasreceitasapp.domain.model.FullRecipeDomain
import com.example.minhasreceitasapp.domain.model.IngredientDomain
import com.example.minhasreceitasapp.domain.model.PrepareModeDomain
import com.example.minhasreceitasapp.domain.model.RecipeDomain
import com.example.minhasreceitasapp.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(private val dao: RecipeDao) : RecipeRepository {
    override suspend fun getAll(): List<RecipeDomain> = withContext(Dispatchers.IO){
        dao.getAll().map {
            it.toDomain()
        }
    }

    override suspend fun insert(recipe: RecipeDomain) = withContext(Dispatchers.IO){
        dao.insert(recipe.toEntity())
    }

    override suspend fun getRecipeWithIngredientsAndPrepareMode(idRecipe: Int): FullRecipeDomain =
        withContext(Dispatchers.IO){
        dao.getRecipeWithIngredientsAndPrepareModes(idRecipe).toDomain()
    }
    override suspend fun insertIngredient(ingredient: IngredientDomain)
    = withContext(Dispatchers.IO){
        dao.insert(
            Ingredient(
                id = ingredient.id,
                name = ingredient.name,
                idRecipe = ingredient.idRecipe
            )
        )
    }

    override suspend fun insertPrepareMode(prepareMode: PrepareModeDomain) =
        withContext(Dispatchers.IO){
        dao.insert(
            prepareMode.toEntity()
        )
    }
    override suspend fun updateIngredient(ingredient: IngredientDomain) = withContext(Dispatchers.IO){
        dao.updateIngredient(ingredient.toEntity())
    }

    override suspend fun updatePrepareMode(prepareMode: PrepareModeDomain) =
        withContext(Dispatchers.IO) {
            dao.updatePrepareMode(prepareMode.toEntity())
        }
}
