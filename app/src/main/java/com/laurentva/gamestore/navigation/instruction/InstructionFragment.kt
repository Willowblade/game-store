package com.laurentva.gamestore.navigation.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.laurentva.gamestore.R
import com.laurentva.gamestore.databinding.InstructionFragmentBinding
import com.laurentva.gamestore.navigation.instruction.InstructionFragmentDirections

class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.instruction_fragment, container, false)

        binding.enterButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                InstructionFragmentDirections.actionInstructionFragmentToGameListFragment()))

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}