package com.example.cae_app.pertemuan_3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cae_app.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan View Binding
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Ambil data dari Intent
        // Di HomeFragment tadi kita kirim "USERNAME", di sini kita terima
        val name = intent.getStringExtra("USERNAME") ?: "Penghuni"

        // 2. Set Teks ke UI (Menyesuaikan Tema Kost)
        binding.tvWelcome.text = "Detail Kamar VIP - 01"
        binding.tvDesc.text = "Halo $name, kamar ini memiliki fasilitas lengkap seperti AC, WiFi, Kamar Mandi Dalam, dan Kasur Queen Size. Lokasi strategis dekat dengan pusat kota."

        // 3. Tombol Booking / Pesan Kamar
        binding.btnPesanPaket.setOnClickListener {
            showToast("Permintaan Booking terkirim ke Ibu Kost! 🏠")
        }

        // 4. Tombol Kembali
        binding.btnBackToDashboard.setOnClickListener {
            finish() // Menutup halaman ini dan balik ke Dashboard
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}