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
import java.util.*

class CharacterFragment : Fragment() {

    private val args: CharacterFragmentArgs by navArgs()

    private lateinit var binding: FragmentCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_character, container, false)

        val character = args.character
        fun getYearOfBirth(dob:String):Int{
            return "${dob[dob.lastIndex-3]}${dob[dob.lastIndex-2]}${dob[dob.lastIndex-1]}${dob[dob.lastIndex]}".toInt()
        }
        val characterAgeNow= (2021-getYearOfBirth(character.dateOfBirth)).toString()
        binding.apply {
            characterAge.text=characterAgeNow
            characterName.text=character.name
            characterSpecies.text=character.species
            characterEye.text= character.eyeColour
            characterHair.text=character.house

        }
        Glide.with(requireActivity()).load(character.image).into(binding.characterImage)


        return binding.root
    }
}