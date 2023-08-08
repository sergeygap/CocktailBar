package com.gap.cocktailbar.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gap.cocktailbar.R
import com.gap.cocktailbar.databinding.FragmentDetailsBinding
import com.gap.cocktailbar.presentation.cocktails.MyCocktailsFragment
import com.gap.cocktailbar.presentation.edit.EditFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class DetailsFragment : Fragment() {


    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: DetailsViewModel
    private var id: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity())[DetailsViewModel::class.java]
        inputArguments()
        deleteButton()


    }

    private fun deleteButton() {
        binding.delete.setOnClickListener {
            deleteDialog()

        }
    }

    private fun inputArguments() {
        val title = requireArguments().getString(TITLE)
        if (title != null) {
            binding.title.text = title
        }
        val description = requireArguments().getString(DESCRIPTION)
        if (description != null) {
            binding.description.text = description
        }
        val recept = requireArguments().getString(RECEPT)
        if (recept != null) {
            binding.recept.text = recept
        }
        val ingr = requireArguments().getString(INGR)
        if (recept != null) {
            binding.ingredients.text = ingr
        }
        val id = requireArguments().getInt(ID)
        if (id != null) {
            this.id = id
        }
//        editFragmentStart(title, description, recept)


    }

    private fun editFragmentStart(title: String?, description: String?, recept: String?) {
        binding.edit.setOnClickListener {
            val fragment = EditFragment()
            val bundle = Bundle().apply {
                putString(TITLE, title)
                putString(DESCRIPTION, description)
                putString(RECEPT, recept)
            }
            fragment.arguments = bundle
            launchFragment(fragment)
        }
    }

    private fun deleteDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.alert_title))
            .setMessage(getString(R.string.alert_message))
            .setCancelable(false)
            .setNegativeButton(getString(R.string.no)) { _, _ -> }
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                mainViewModel.delete(id)
                launchFragment(MyCocktailsFragment())
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

    companion object {
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val RECEPT = "recept"
        const val INGR = "ingr"
        const val ID = "id"
    }

}