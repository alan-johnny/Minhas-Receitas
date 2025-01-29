package com.example.minhasreceitasapp.data.mapper

import com.example.minhasreceitasapp.data.entity.PrepareModeEntity
import com.example.minhasreceitasapp.domain.model.PrepareModeDomain

fun PrepareModeDomain.toEntity() = PrepareModeEntity(
    id = id,
    name = name,
    idRecipe = idRecipe
)

fun PrepareModeEntity.toDomain() = PrepareModeDomain(
    id = id,
    name = name,
    idRecipe = idRecipe
)