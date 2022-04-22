package com.example.uidemo.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.uidemo.R
import com.example.uidemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var textCartItemCount : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.toolbar)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.category_menu,menu)
        val menuItem : MenuItem = menu.findItem(R.id.category_notifications)
        val actionView : View = menuItem.actionView
        textCartItemCount = actionView.findViewById(R.id.cart_badge) as TextView

        setupBadge(2)

        return super.onCreateOptionsMenu(menu)
    }

    fun setupBadge(i: Int){
        if (i == 0) {
            if (textCartItemCount.visibility != View.GONE) {
                textCartItemCount.visibility = View.GONE;
            }
        } else {
            textCartItemCount.text = i.toString()
            if (textCartItemCount.visibility != View.VISIBLE) {
                textCartItemCount.visibility = View.VISIBLE;
            }
        }
    }
}