package com.android.appvideo

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.appvideo.ui.main.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), OnFilmClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
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


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }

    override fun onClick(itemId: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, DetailFragment.newInstance(itemId))
            .addToBackStack("")
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.navigate_bottom, menu)
        return true
    }
}