package com.example.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentDetailBinding
import com.example.shoestore.model.ShoeModel
import com.example.shoestore.viewModel.ShoeProductViewModel

class DetailFragment:Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: ShoeProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )
        viewModel = ViewModelProvider(requireActivity()).get(ShoeProductViewModel::class.java)
        binding.productViewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnCancel.setOnClickListener {
            Toast.makeText(context,"Cancelled.",Toast.LENGTH_SHORT).show()
            findNavController().navigate(DetailFragmentDirections.actionProductDetailsFragmentToShoeListFragment())

        }
        binding.btnSave.setOnClickListener {
            val img: ArrayList<Int> = ArrayList()
            img.add(R.drawable.sneaker)

            viewModel.addItem(ShoeModel(binding.shoeName.text.toString(),
                binding.shoeSize.text.toString(),
                binding.companyName.text.toString(),
                binding.description.text.toString()
                ,img))
            binding.shoeName.getText()
            Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show()
            findNavController().navigate(DetailFragmentDirections.actionProductDetailsFragmentToShoeListFragment())

        }
        return binding.root
    }
}