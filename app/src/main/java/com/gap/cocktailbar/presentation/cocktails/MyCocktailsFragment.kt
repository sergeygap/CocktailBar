package com.gap.cocktailbar.presentation.cocktails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gap.cocktailbar.R
import com.gap.cocktailbar.databinding.FragmentMyCocktailsBinding
import com.gap.cocktailbar.presentation.create.CreateCocktailFragment


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
        mainViewModel = ViewModelProvider(requireActivity())[MyCocktailsViewModel::class.java]
        mainViewModel.getCocktails().observe(requireActivity(), Observer {
            myCocktailsAdapter.setCocktails(it)
        })
        binding.fabAdd.setOnClickListener {
            launchFragment(CreateCocktailFragment())
        }

    }
     fun launchFragment(fragment: Fragment) {
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