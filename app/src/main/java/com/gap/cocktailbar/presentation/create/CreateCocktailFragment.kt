package com.gap.cocktailbar.presentation.create

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
import com.gap.cocktailbar.databinding.FragmentCreateCocktailBinding
import com.gap.cocktailbar.presentation.cocktails.MyCocktailsFragment


class CreateCocktailFragment : Fragment() {


    private var _binding: FragmentCreateCocktailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CreateCocktailFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateCocktailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveListener()
        viewModel =
            ViewModelProvider(requireActivity())[CreateCocktailFragmentViewModel::class.java]
        titleListeners()
        cancelPressed()
    }

    private fun cancelPressed() {
        binding.cancel.setOnClickListener {
            requireActivity().onBackPressed()
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

    private fun saveListener() {
        binding.save.setOnClickListener {
            val title: String = binding.titleEt.text.toString().trim()
            if (title.isEmpty()) {
                binding.titleIl.error = "The field cannot be empty"
            } else {
                val cocktails = Cocktails(title = title)
                viewModel.addCocktails(cocktails)
                launchFragment(MyCocktailsFragment())
            }
        }
    }


    private fun launchFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_fragment_container_view,
                fragment
            )
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}