package com.gap.cocktailbar.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gap.cocktailbar.databinding.FragmentMyCocktailsBinding


class MyCocktailsFragment : Fragment() {

    private var _binding: FragmentMyCocktailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var myCocktailsAdapter: MyCocktailsAdapter

    private lateinit var mainViewModel: MyCocktailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyCocktailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myCocktailsAdapter = MyCocktailsAdapter()
        binding.recyclerView.adapter = myCocktailsAdapter
//        mainViewModel.getCocktails().observe(requireActivity(), Observer<List<Cocktails>> { cocktails -> myCocktailsAdapter.setCocktails(cocktails) })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}