package com.laurentva.gamestore.navigation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.laurentva.gamestore.R
import com.laurentva.gamestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        binding.logIn.setOnClickListener(Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))
        binding.register.setOnClickListener(Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}