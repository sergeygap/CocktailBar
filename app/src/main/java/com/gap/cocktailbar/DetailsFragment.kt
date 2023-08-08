package com.gap.cocktailbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gap.cocktailbar.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {


    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputArguments()
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
            binding.receptHint.visibility = View.INVISIBLE
            binding.recept.text = recept
        } else {
            binding.receptHint.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val RECEPT = "recept"
    }

}