package com.example.minhasreceitasapp.presentation.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.minhasreceitasapp.databinding.FragmentFirstBinding
import com.example.minhasreceitasapp.presentation.recipe.adapter.RecipeAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecipeFragment : Fragment() {


    private val viewModel: RecipesViewModel by viewModels {
        RecipesViewModel.fatory()
    }
    private lateinit var binding: FragmentFirstBinding
    private val adapter by lazy { RecipeAdapter()}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupAdapter()
        observeState()

    }

    private fun setupListeners() {
        binding.fabRecipe.setOnClickListener{
            //@TODO show dialog
        }
    }
    fun setupAdapter(){
        binding.rvRecipes.adapter = adapter
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is RecipeState.Loading-> {
                    binding.pbLoading.isVisible = true
                }
                is RecipeState.Success -> {
                    binding.pbLoading.isVisible = false
                    adapter.submitList(state.recipe)
                }
                is RecipeState.Empty -> {
                    binding.pbLoading.isVisible = false
                    Toast.makeText(requireContext(), "Nenhuma receita encontrada", Toast.LENGTH_SHORT).show()
                }
                is RecipeState.Error -> {
                   binding.pbLoading.isVisible = false
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

    }
}