package com.example.cae_app.pertemuan_4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cae_app.databinding.ActivityDashboardBinding
import com.example.cae_app.pertemuan_2.HitungActivity
import com.example.cae_app.pertemuan_3.LoginActivity
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Pastikan Binding merujuk ke layout yang benar
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        // 2. Ambil nama admin dari Intent atau SharedPreferences (Biar gak kosong)
        val namaAdmin = intent.getStringExtra("USERNAME") ?: "Echa Admin"
        // Pastikan ID tvAdmin ini ada di XML Dashboard kamu, kalau tidak ada, hapus baris bawah ini
        // binding.tvAdmin.text = namaAdmin

        // 3. Navigasi ke Hitung Activity
        binding.btnHitung.setOnClickListener {
            val intent = Intent(this, HitungActivity::class.java)
            startActivity(intent)
        }

        // 4. Navigasi ke Custom2 (Kost-kostan)
        binding.btnWeb.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("TITLE", "Kost Eksklusif Bina Desa")
            startActivity(intent)
        }

        // 5. Tombol Logout
        binding.btnLogout.setOnClickListener {
            showLogoutDialog()
        }
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Yakin ingin keluar?")
            .setPositiveButton("Ya") { _, _ -> performLogout() }
            .setNegativeButton("Tidak", null)
            .show()
    }

    private fun performLogout() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}