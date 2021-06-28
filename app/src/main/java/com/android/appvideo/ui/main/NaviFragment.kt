package com.android.appvideo.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.appvideo.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class NaviFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadFragment(MainFragment())
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val navigate = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigate.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_main -> {
                    Toast.makeText(this, "Фильмы", Toast.LENGTH_SHORT).show()
                    loadFragment(MainFragment())
                }
                R.id.nav_favorite -> {
                    Toast.makeText(this, "Избраное", Toast.LENGTH_SHORT).show()
                    loadFragment(FavoriteFragment())
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .commit()
    }
}