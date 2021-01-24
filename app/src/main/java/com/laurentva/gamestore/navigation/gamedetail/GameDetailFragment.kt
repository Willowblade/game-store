package com.laurentva.gamestore.navigation.gamedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.laurentva.gamestore.GamesViewModel
import com.laurentva.gamestore.R
import com.laurentva.gamestore.databinding.GameDetailFragmentBinding
import com.laurentva.gamestore.models.Game

class GameDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameDetailFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.game_detail_fragment, container, false)
        val gameModel: GamesViewModel =
            ViewModelProvider(requireActivity()).get(GamesViewModel::class.java)
        val game = Game("", "", "", "", R.drawable.no_game)
        binding.game = game

        binding.addGameButton.setOnClickListener {
            if (game.name.isNotBlank() && game.description.isNotBlank() && game.company.isNotBlank() && game.platform.isNotBlank()) {
                gameModel.addGame(game)
                Navigation.findNavController(it)
                    .navigate(GameDetailFragmentDirections.actionGameDetailFragmentToGameListFragment())

            } else {
                Toast.makeText(
                    requireContext(),
                    "You need to fill in all the fields",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }
}