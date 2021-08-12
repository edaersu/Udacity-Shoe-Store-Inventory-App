package com.example.shoestore.screens

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentListingBinding
import com.example.shoestore.model.Item
import com.example.shoestore.viewModel.ShoeProductViewModel

class ListingFragment :Fragment() {
    private lateinit var binding: FragmentListingBinding
    private lateinit var viewModel: ShoeProductViewModel
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
        viewModel = ViewModelProvider(requireActivity()).get(ShoeProductViewModel::class.java)

        binding.productViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            if (!shoeList.isNullOrEmpty()) {
                shoeList.forEach { shoe ->
                    val shoeItem = Item(context)
                    shoeItem.setProduct(
                        shoe.images[0],
                        shoe.name,
                        shoe.description,
                        shoe.company,
                        shoe.size
                    )
                    val myLayout: LinearLayout = binding.shoeContainer

                    shoeItem.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    myLayout.addView(shoeItem)
                }
            }
        })

        binding.goToDetailBtn.setOnClickListener {
            findNavController().navigate(ListingFragmentDirections.actionShoeListFragmentToProductDetailsFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.logout) {
            findNavController().navigate(ListingFragmentDirections.actionShoeListFragmentToLoginFragment())
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}
