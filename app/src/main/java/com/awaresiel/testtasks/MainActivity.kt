package com.awaresiel.testtasks

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navGraph: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TestTaskApplication.appComponent.inject(activity = this@MainActivity)
        setContentView(R.layout.activity_main)
        setupView()
    }



    private fun setupView(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment
        navGraph = navHostFragment.navController
        NavigationUI.setupWithNavController(navigationMenu, navHostFragment.navController)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.albumsViewFragment, R.id.songsViewFragment))
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)
    }

    private var backPressedOnce = false

    override fun onBackPressed() {
        if (navGraph.graph.startDestination == navGraph.currentDestination?.id)
        {
            if (backPressedOnce)
            {
                super.onBackPressed()
                return
            }

            backPressedOnce = true
            Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show()

            Handler().postDelayed(2000) {
                backPressedOnce = false
            }
        }
        else {
            super.onBackPressed()
        }
    }

}