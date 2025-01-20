package com.example.minhasreceitasapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FullRecipe(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "idRecipe",
    )
    val ingredients: List<IngredientEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "idRecipe",
    )
    val prepareModes: List<PrepareModeEntity>
)
