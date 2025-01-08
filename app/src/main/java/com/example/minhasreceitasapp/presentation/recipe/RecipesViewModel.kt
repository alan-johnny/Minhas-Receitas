package com.example.minhasreceitasapp.presentation.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.minhasreceitasapp.data.db
import com.example.minhasreceitasapp.data.repository.RecipeRepositoryImpl
import com.example.minhasreceitasapp.domain.model.RecipeDomain
import com.example.minhasreceitasapp.domain.usecase.GetAllRecipeUseCase
import com.example.minhasreceitasapp.domain.usecase.InsertRecipeUseCase
import kotlinx.coroutines.launch

class RecipesViewModel(
    private val getAllRecipeUseCase: GetAllRecipeUseCase,
    private val insertRecipeUseCase: InsertRecipeUseCase
): ViewModel() {
    val state: LiveData<RecipeState> = liveData {
        emit(RecipeState.Loading)
       try {
            val recipes = getAllRecipeUseCase()
            if (recipes.isEmpty()) {
                emit(RecipeState.Empty)
            } else {
                emit(RecipeState.Success(recipes))
            }
        } catch (e: Exception) {
            emit(RecipeState.Error(e.message ?: "Unknown error"))
        }
    }


    fun insert(name: String) = viewModelScope.launch {
        insertRecipeUseCase(RecipeDomain(name = name))
    }

    class fatory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras ): T {
            val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
            val repository = RecipeRepositoryImpl(application.db.recipeDao())
            return RecipesViewModel(
                getAllRecipeUseCase = GetAllRecipeUseCase(repository),
                insertRecipeUseCase = InsertRecipeUseCase(repository)
            ) as T
        }
    }
}