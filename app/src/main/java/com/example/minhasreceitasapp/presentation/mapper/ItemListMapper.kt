package com.example.minhasreceitasapp.presentation.mapper

import com.example.minhasreceitasapp.domain.model.IngredientDomain
import com.example.minhasreceitasapp.domain.model.PrepareModeDomain
import com.example.minhasreceitasapp.presentation.model.ItemListModel


fun IngredientDomain.toModel() = ItemListModel(
    id = id,
    name = name
)

fun List<IngredientDomain>.toModelIngredient() = map {
    it.toModel()
}

fun PrepareModeDomain.toModel() = ItemListModel(
    id = id,
    name = name
)

fun List<PrepareModeDomain>.toModelPrepareMode() = map {
    it.toModel()
}