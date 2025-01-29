package com.example.minhasreceitasapp.data.mapper

import com.example.minhasreceitasapp.data.entity.IngredientEntity
import com.example.minhasreceitasapp.domain.model.IngredientDomain


fun IngredientDomain.toEntity() = IngredientEntity(
    id = id,
    name = name,
    idRecipe = idRecipe
)

fun IngredientEntity.toDomain() = IngredientDomain(
    id = id,
    name = name,
    idRecipe = idRecipe
)