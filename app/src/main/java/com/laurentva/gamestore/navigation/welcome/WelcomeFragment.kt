package com.laurentva.gamestore.navigation.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.laurentva.gamestore.R
import com.laurentva.gamestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)

        binding.enterButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()))

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}