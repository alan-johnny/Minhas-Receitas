package com.example.minhasreceitasapp.data.mapper

import com.example.minhasreceitasapp.data.entity.RecipeEntity
import com.example.minhasreceitasapp.domain.model.RecipeDomain

fun RecipeDomain.toEntity() = RecipeEntity(
    id = id,
    name = name,
    prepareTime = prepareTime
)

fun RecipeEntity.toDomain() = RecipeDomain(
    id = id,
    name = name,
    prepareTime = prepareTime
)