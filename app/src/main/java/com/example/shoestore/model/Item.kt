package com.example.shoestore.model

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.shoestore.R

class Item : LinearLayout {
    private var productImage: ImageView? = null
    private var productNameTextView: TextView? = null
    private var productDescriptionTextView: TextView? = null
    private var companyNameTextView: TextView? = null
    private var productSizeTextView: TextView? = null


    constructor(context: Context?) : super(context!!) {
        initialize()
    }

    private fun initialize() {
        LayoutInflater.from(context)
            .inflate(R.layout.item, this)
        productImage = findViewById(R.id.product_image_View)
        productNameTextView = findViewById(R.id.name_text)
        productDescriptionTextView = findViewById(R.id.description_text)
        companyNameTextView = findViewById(R.id.company_name_text)
        productSizeTextView = findViewById(R.id.product_size_text)
    }

    fun setProduct(
        image: Int, productName: String, productDescription: String,
        companyName: String, productSize: String
    ) {
        productImage?.setBackgroundResource(image)
        productNameTextView?.text = productName
        productDescriptionTextView?.text = productDescription
        companyNameTextView?.text = companyName
        productSizeTextView?.text = productSize.toString()
    }
}