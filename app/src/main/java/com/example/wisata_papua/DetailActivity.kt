package com.example.wisata_papua

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wisata_papua.ui.detail.DetailFragment

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Ambil data dari Intent
        val title = intent.getStringExtra("TITLE") ?: "No Title"

        // Tampilkan Fragment
        val fragment = DetailFragment.newInstance(title)

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_detail, fragment)
            .commit()
    }
}