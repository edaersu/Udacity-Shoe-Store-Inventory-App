package com.example.shoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.R
import com.example.shoestore.model.ShoeModel

class ShoeProductViewModel: ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<ShoeModel>>()
    val shoeList: MutableLiveData<MutableList<ShoeModel>>
        get() = _shoeList

    init {
        initializeShoeList()
    }

    private fun initializeShoeList() {
        val shoe1Images: ArrayList<Int> = ArrayList()
        shoe1Images.add(R.drawable.shoe)
        val shoe1 = ShoeModel(
            "s1", "42", "c1", "d1",
            shoe1Images
        )

        val shoe2Images: ArrayList<Int> = ArrayList()
        shoe2Images.add(R.drawable.shoe)
        val shoe2 = ShoeModel(
            "s2", "36", "c2", "d2",
            shoe2Images
        )

        val shoe3Images: ArrayList<Int> = ArrayList()
        shoe3Images.add(R.drawable.shoe)
        val shoe3 = ShoeModel(
            "s2", "39", "c3", "d3",
            shoe3Images
        )
        _shoeList.value = mutableListOf(shoe1, shoe2, shoe3)
    }

    fun addItem(shoe:ShoeModel){
       _shoeList.value?.add(shoe)
    }
}