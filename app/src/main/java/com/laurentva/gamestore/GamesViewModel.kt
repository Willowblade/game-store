package com.laurentva.gamestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laurentva.gamestore.models.Game


class GamesViewModel : ViewModel() {
    val _games = MutableLiveData<MutableList<Game>>()
    val games: LiveData<MutableList<Game>>
        get() = _games

    init {
      _games.value = mutableListOf(
          Game("Cyberpunk 2077", "Windows", "CDPR", "Very ambitious and disappointing bugfest", R.mipmap.cyberpunk),
          Game("League of Legends", "Windows", "Riot Games", "Get mad with friends in this amazing MOBA game", R.mipmap.league),
          Game("Cyberpunk 2077", "Windows", "CDPR", "Very ambitious and disappointing bugfest", R.mipmap.cyberpunk),
          Game("League of Legends", "Windows", "Riot Games", "Get mad with friends in this amazing MOBA game", R.mipmap.league),
          Game("Cyberpunk 2077", "Windows", "CDPR", "Very ambitious and disappointing bugfest", R.mipmap.cyberpunk),
          Game("League of Legends", "Windows", "Riot Games", "Get mad with friends in this amazing MOBA game", R.mipmap.league),
          Game("Cyberpunk 2077", "Windows", "CDPR", "Very ambitious and disappointing bugfest", R.mipmap.cyberpunk),
          Game("League of Legends", "Windows", "Riot Games", "Get mad with friends in this amazing MOBA game", R.mipmap.league),
      )
    }

    fun addGame(game: Game) {
        _games.value?.add(game)
    }

    fun addGameFromData(name: String, platform: String, publisher: String, description: String) {
        addGame(Game(name, platform, publisher, description, R.mipmap.no_game))
    }

    fun removeGame(gameTitle: String) {
        val game = _games.value?.find { it.name == gameTitle }!!
        _games.value?.remove(game);
    }
}

