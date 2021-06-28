package com.android.appvideo

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.android.appvideo.ui.main.*

class MainActivity : AppCompatActivity(), OnFilmClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        NaviFragment()
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