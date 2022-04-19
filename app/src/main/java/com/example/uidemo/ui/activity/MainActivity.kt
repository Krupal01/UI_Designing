package com.example.uidemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.uidemo.R
import com.example.uidemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.mainBottomNav.setupWithNavController(navHostFragment.navController)

        setCartBadges(2)

    }

    fun setCartBadges(i: Int) {
        var badge = binding.mainBottomNav.getOrCreateBadge(R.id.cartFragment)
        badge.isVisible = true
        badge.number = i
    }

    fun setToolbar(toolbar: Toolbar?) {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            val toggle = ActionBarDrawerToggle(this,
                binding.layoutDrawer,
                toolbar,
                R.string.nav_open,
                R.string.nav_close
            )
            toggle.syncState()
            binding.layoutDrawer.setDrawerListener(toggle)
            toggle.syncState()
        } else {
            binding.layoutDrawer.setDrawerListener(null)
        }
    }
}