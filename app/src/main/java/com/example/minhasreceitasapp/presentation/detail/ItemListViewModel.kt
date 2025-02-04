package com.example.minhasreceitasapp.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.minhasreceitasapp.data.db
import com.example.minhasreceitasapp.data.repository.RecipeRepositoryImpl
import com.example.minhasreceitasapp.domain.model.PrepareModeDomain
import com.example.minhasreceitasapp.domain.usecase.GetRecipeWithIngredientsAndPrepareModeUseCase
import com.example.minhasreceitasapp.domain.usecase.InsertIngredientsUseCase
import com.example.minhasreceitasapp.domain.usecase.InsertPrepareModeUseCase
import kotlinx.coroutines.launch
import com.example.minhasreceitasapp.presentation.mapper.toModelIngredient
import com.example.minhasreceitasapp.presentation.mapper.toModelPrepareMode
import com.example.minhasreceitasapp.domain.model.IngredientDomain

class ItemListViewModel(
    private val getRecipeWithIngredientsAndPrepareModeUseCase: GetRecipeWithIngredientsAndPrepareModeUseCase,
    private val insertIngredientsUseCase: InsertIngredientsUseCase,
    private val insertPrepareModeUseCase: InsertPrepareModeUseCase
) : ViewModel() {

    fun getRecipeWithIngredientsAndPrepareMode(idRecipe: Int): LiveData<ItemListState> = liveData {
        emit(ItemListState.Loading)
        val state = try {
            val fullRecipe = getRecipeWithIngredientsAndPrepareModeUseCase(idRecipe)
            ItemListState.Success(
                ingredients = fullRecipe.ingredients.toModelIngredient(),
                prepareMode = fullRecipe.prepareMode.toModelPrepareMode()
            )
        } catch (exception: Exception) {
            Log.e("Error", exception.message.toString())
            ItemListState.Error(exception.message.toString())
        }
        emit(state)
    }

    fun insertIngredientsOrPrepareMode(
        typeInsert: String,
        name: String,
        idRecipe: Int
    ) = viewModelScope.launch {
        if (typeInsert == "INGREDIENT") {
            insertIngredientsUseCase(
                IngredientDomain(
                    name = name,
                    idRecipe = idRecipe

                )
            )
        } else {
            insertPrepareModeUseCase(
                PrepareModeDomain(
                    name = name,
                    idRecipe = idRecipe
                )
            )
        }
    }

    fun updateIngredient() {
        //@TODO realizar o update do ingredient
    }

    fun removeIngredient() {
        //@TODO realizar a exclusao do ingredient
    }

    fun updatePrepareMode() {
        //@TODO realizar o update do modo de preparo
    }

    fun removePrepareMode() {
        //@TODO realizar o update do modo de preparo
    }

    class Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            val application = checkNotNull(extras[APPLICATION_KEY])
            val repository = RecipeRepositoryImpl(application.db.recipeDao())
            return ItemListViewModel(
                getRecipeWithIngredientsAndPrepareModeUseCase = GetRecipeWithIngredientsAndPrepareModeUseCase(
                    repository
                ),
                insertIngredientsUseCase = InsertIngredientsUseCase(repository),
                insertPrepareModeUseCase = InsertPrepareModeUseCase(repository)
            ) as T
        }
    }

}
