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
        val img: ArrayList<Int> = ArrayList()
        img.add(R.drawable.puma)
        val shoe1 = ShoeModel(
            "LQDCELL Colorblock", "42", "Puma", "Women",
            img
        )
        val img2: ArrayList<Int> = ArrayList()
        img2.add(R.drawable.levis)
        val shoe2 = ShoeModel(
            "Sneaker", "36", "Levi's", "Unisex",
            img2
        )
        val img3: ArrayList<Int> = ArrayList()
        img3.add(R.drawable.airmax)
        val shoe3 = ShoeModel(
            "Air Max Impact 2 ", "39", "Nike", "Women",
            img3
        )
        _shoeList.value = mutableListOf(shoe1, shoe2, shoe3)
    }

    fun addItem(shoe:ShoeModel){
       _shoeList.value?.add(shoe)
    }
}