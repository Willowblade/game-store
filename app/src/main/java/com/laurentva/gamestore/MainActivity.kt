package com.laurentva.gamestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.laurentva.gamestore.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: GamesViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        Timber.plant(Timber.DebugTree())

        val navController = findNavController(R.id.fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupWithNavController(binding.toolbar, navController)

        Timber.i("Started the app!")


        viewModel = ViewModelProvider(this).get(GamesViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        Timber.i("Pressed the navigate up...")
        val navController = Navigation.findNavController(this, R.id.fragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}
