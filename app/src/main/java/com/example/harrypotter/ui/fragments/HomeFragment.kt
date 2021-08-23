package com.example.harrypotter.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.harrypotter.R
import com.example.harrypotter.data.local.CharacterCacheDao
import com.example.harrypotter.data.remote.NetworkDataMapper
import com.example.harrypotter.data.remote.PotterService
import com.example.harrypotter.data.repository.PotterRepository
import com.example.harrypotter.databinding.FragmentHomeBinding
import com.example.harrypotter.ui.adapters.CharacterAdapter
import com.example.harrypotter.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel  by viewModels<HomeViewModel>()

    private lateinit var binding : FragmentHomeBinding

    private val adapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        adapter.setOnCoinClickListener {
            val bundle = Bundle().apply {
                putSerializable("character",it)
            }
            findNavController().navigate(R.id.action_homeFragment_to_characterFragment,bundle)
        }

        homeViewModel.netCharacters.observe(viewLifecycleOwner,{ charactersFromServer->
            val convertedCharacters = NetworkDataMapper().createListFromEntityList(charactersFromServer)
            adapter.differ.submitList(convertedCharacters)
            binding.apply {
                rvStaff.adapter=adapter
                rvStudents.adapter= adapter
            }
        })

        return binding.root
    }
}