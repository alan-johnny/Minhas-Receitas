package com.example.minhasreceitasapp.presentation.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.minhasreceitasapp.R
import com.example.minhasreceitasapp.databinding.FragmentFirstBinding
import com.example.minhasreceitasapp.presentation.recipe.adapter.RecipeAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecipeFragment : Fragment() {

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

    }

    private fun setupListeners() {
        binding.fabRecipe.setOnClickListener{
            //@TODO show dialog
        }
    }
    fun setupAdapter(){
        binding.rvRecipes.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()

    }
}