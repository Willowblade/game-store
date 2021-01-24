package com.laurentva.gamestore.navigation.gamelist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.laurentva.gamestore.R
import com.laurentva.gamestore.databinding.GameListFragmentBinding
import com.laurentva.gamestore.GamesViewModel
import com.laurentva.gamestore.databinding.GameListDetailFragmentBinding
import timber.log.Timber

class GameListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.game_list_fragment, container, false)
        val gameModel: GamesViewModel = ViewModelProvider(requireActivity()).get(GamesViewModel::class.java)

        Timber.i("We're using the following games!")
        gameModel.games.value?.forEach { game ->
            Timber.i(game.name)
//            val view = View.inflate(context, R.layout.game_list_detail_fragment, binding.gamesLayout)
            val view: GameListDetailFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.game_list_detail_fragment, binding.gamesLayout, true)
            view.name.text = game.name
            view.description.text = game.description
            view.company.text = game.company
            view.platform.text = game.platform
            view.image.setImageResource(game.image)
        }

        setHasOptionsMenu(true)

        binding.addGameButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                GameListFragmentDirections.actionGameListFragmentToGameDetailFragment()))

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Timber.i("Creating options menu!")
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            (R.id.loginFragment) -> {
                Timber.i("Pressed logout!")
                Navigation.findNavController(requireView()).navigate(GameListFragmentDirections.actionGameListFragmentToLoginFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }
}