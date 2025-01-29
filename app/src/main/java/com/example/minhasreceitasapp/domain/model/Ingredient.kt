package com.example.minhasreceitasapp.domain.model

typealias IngredientDomain = Ingredient
data class Ingredient(
    val id: Int,
    val name: String,
    val idRecipe: Int
)
