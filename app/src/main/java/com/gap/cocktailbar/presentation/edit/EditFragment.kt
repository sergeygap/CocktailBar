package com.gap.cocktailbar.presentation.edit

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gap.cocktailbar.R
import com.gap.cocktailbar.data.Cocktails
import com.gap.cocktailbar.databinding.FragmentEditBinding
import com.gap.cocktailbar.presentation.cocktails.MyCocktailsFragment
import com.gap.cocktailbar.presentation.details.DetailsFragment


class EditFragment : Fragment() {


    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EditViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputArguments()
        saveListener()
        viewModel =
            ViewModelProvider(requireActivity())[EditViewModel::class.java]
        titleListeners()
        cancelPressed()
    }
    private fun inputArguments() {
        val title = requireArguments().getString(DetailsFragment.TITLE)
        if (title != null) {
            binding.titleEt
        }
        val description = requireArguments().getString(DetailsFragment.DESCRIPTION)
        if (description != null) {
            binding.descriptionEt.setText(description)
        }
        val recept = requireArguments().getString(DetailsFragment.RECEPT)
        if (recept != null) {
            binding.recipeEt.setText(recept)
        }
    }
    private fun cancelPressed() {
        binding.cancel.setOnClickListener {
            launchFragment(DetailsFragment())
        }
    }

    private fun saveListener() {
        binding.save.setOnClickListener {
            val title: String = binding.titleEt.text.toString().trim()
            val description: String = binding.descriptionEt.text.toString().trim()
            val recept: String = binding.recipeEt.text.toString().trim()
            if (title.isEmpty()) {
                binding.titleIl.error = "The field cannot be empty"
            } else {
                val cocktails = Cocktails(title = title, description = description, recipe = recept)
                viewModel.addCocktails(cocktails)
                launchFragment(MyCocktailsFragment())
            }
        }
    }

    private fun titleListeners() {
        binding.titleEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Убрать ошибку, если пользователь начал вводить текст
                binding.titleIl.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun launchFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_fragment_container_view,
                fragment
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}