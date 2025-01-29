package com.example.minhasreceitasapp.data.mapper

import com.example.minhasreceitasapp.data.entity.FullRecipe
import com.example.minhasreceitasapp.data.entity.FullRecipeEntity
import com.example.minhasreceitasapp.domain.model.FullRecipeDomain
import com.example.minhasreceitasapp.domain.model.IngredientDomain


fun FullRecipeEntity.toDomain() = FullRecipeDomain(
    recipe = recipe.toDomain(),
    ingredients = ingredients.map {
        IngredientDomain(
            id = it.id,
            name = it.name,
            idRecipe = it.idRecipe
        )
    },
        prepareMode = prepareMode.map {
             it.toDomain()
        }
)