package com.example.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentListingBinding

class ListingFragment :Fragment(){
    private lateinit var binding: FragmentListingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_listing,
            container,
            false
        )
        return binding.root
    }
}