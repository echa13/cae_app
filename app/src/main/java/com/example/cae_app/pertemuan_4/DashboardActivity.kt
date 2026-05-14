package com.example.cae_app.pertemuan_4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cae_app.R
import com.example.cae_app.databinding.ActivityDashboardBinding
import com.example.cae_app.pertemuan_3.LoginActivity
import com.example.cae_app.pertemuan_6.AboutFragment
import com.example.cae_app.pertemuan_6.HomeFragment
import com.example.cae_app.pertemuan_6.ProfileFragment

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi Binding
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Bina Desa"

        // 3. SET DEFAULT FRAGMENT (Agar saat login langsung muncul HomeFragment)
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            // Opsional: Pastikan menu Home di bawah terpilih warnanya
            binding.bottomNavigation.selectedItemId = R.id.nav_home
        }

        // 4. Setup Navigasi Bottom Navigation
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_about -> replaceFragment(AboutFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    // Fungsi untuk memindahkan fragment ke dalam fragment_container
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // Fungsi Logout - PUBLIC agar bisa diakses ProfileFragment
    public fun performLogout() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}