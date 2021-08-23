package com.example.harrypotter.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.harrypotter.R
import com.example.harrypotter.databinding.FragmentCharacterBinding
import com.example.harrypotter.databinding.FragmentHomeBinding

class CharacterFragment : Fragment() {

    private val args: CharacterFragmentArgs by navArgs()

    private lateinit var binding: FragmentCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_character, container, false)

        val character = args.character
        binding.apply {
            characterAge.text=character.dateOfBirth
            characterName.text=character.name
            characterSpecies.text=character.species

        }
        Glide.with(requireActivity()).load(character.image).into(binding.characterImage)


        return binding.root
    }
}