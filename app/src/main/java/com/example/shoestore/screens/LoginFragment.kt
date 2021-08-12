package com.example.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLoginBinding
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        binding.btnLogin.setOnClickListener {
            control(binding)
        }
        binding.btnSignup.setOnClickListener {
           control(binding)
        }
        return binding.root
    }

    fun control(binding:FragmentLoginBinding){
        if(binding.editEmail.text.toString().isNotEmpty() && binding.editPassword.text.toString().isNotEmpty()){
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        else{
            Toast.makeText(context,"Please enter email and password!",Toast.LENGTH_LONG).show()
        }
    }

}