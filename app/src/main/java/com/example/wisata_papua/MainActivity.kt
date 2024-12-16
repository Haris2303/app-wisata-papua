package com.example.wisata_papua

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisata_papua.databinding.ActivityMainBinding
import com.example.wisata_papua.ui.home.CardAdapter
import com.example.wisata_papua.ui.home.ItemData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Listener untuk fragment yang aktif
        navController.addOnDestinationChangedListener { _, destination, _ ->
            invalidateOptionsMenu() // Refresh menu saat fragment berubah
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val searchItem = menu.findItem(R.id.search_action)
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val searchView = searchItem.actionView as SearchView

        // Menemukan edit text di dalam search view
        val searchEditText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        if (searchEditText != null) {
            searchEditText.setBackgroundResource(R.drawable.search_background)
            searchEditText.setPadding(20, 10, 20, 10)
        } else {
            Log.e("MainActivity", "Search EditText not found")
        }

        when (navController.currentDestination?.id) {
            R.id.navigation_home -> {
                searchItem.isVisible = true
                Log.i("NAVIGATION", "HomeFragment ditemukan")
            }
            R.id.navigation_dashboard -> {
                searchItem.isVisible = false
                Log.i("NAVIGATION", "DashboardFragment ditemukan")
            }
            R.id.navigation_notifications -> {
                searchItem.isVisible = false
                Log.i("NAVIGATION", "NotificationsFragment ditemukan")
            }
            else -> searchItem.isVisible = false
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search_action -> {
                // Tambahkan aksi untuk item pencarian di sini
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
