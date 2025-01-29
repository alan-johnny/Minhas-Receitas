package com.example.minhasreceitasapp.domain.model

typealias PrepareModeDomain = PrepareMode
data class PrepareMode (
    val id: Int,
    val name: String,
    val idRecipe: Int
)