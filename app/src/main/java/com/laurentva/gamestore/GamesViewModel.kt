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
          Game("Cyberpunk 2077", "Windows", "CDPR", "Very ambitious and disappointing bugfest", R.drawable.cyberpunk),
          Game("League of Legends", "Windows", "Riot Games", "Get mad with friends in this amazing MOBA game", R.drawable.league),
          Game("Code Vein", "Windows", "BANDAI NAMCO Studios", "Team up and embark on a journey to the ends of hell", R.drawable.code_vein),
          Game("Football Manager 2021", "Windows", "SEGA", "y. FM21 empowers you like never before to develop your skills and command success at your club. ", R.drawable.football_manager_2021),
          Game("Everspace", "Windows", "ROCKFISH Games", "EVERSPACE™ is a fast-paced single-player spaceship shooter with deep exploration in space and on planets", R.drawable.everspace),
          Game("Resident Evil 2", "Windows", "CAPCOM", "A deadly virus engulfs the residents of Raccoon City in September of 1998", R.drawable.resident_evil),
          Game("Rust", "Windows", "Facepunch Studios", "Build craft get killed and do it all again! The only aim in Rust is to survive.", R.drawable.rust),
      )
    }

    fun addGame(game: Game) {
        _games.value?.add(game)
    }

    fun addGameFromData(name: String, platform: String, publisher: String, description: String) {
        addGame(Game(name, platform, publisher, description, R.drawable.no_game))
    }

    fun removeGame(gameTitle: String) {
        val game = _games.value?.find { it.name == gameTitle }!!
        _games.value?.remove(game);
    }
}

