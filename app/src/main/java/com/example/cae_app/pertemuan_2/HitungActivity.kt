package com.example.cae_app.pertemuan_2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cae_app.databinding.ActivityHitungBinding
import com.example.cae_app.pertemuan_4.DashboardActivity

class HitungActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHitungBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi View Binding
        binding = ActivityHitungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sembunyikan ActionBar bawaan supaya tampilan custom kita terlihat penuh
        supportActionBar?.hide()

        // 2. Ambil data Intent untuk judul (jika ada)
        val title = intent.getStringExtra("TITLE") ?: "MANAJEMEN ASET"
        binding.tvTitleHeader.text = title

        // 3. Jalankan fungsi setup
        setupMenuSwitcher()
        setupKalkulator()

        // 4. Tombol Kembali ke Dashboard
        binding.btnBackToDashboard.setOnClickListener {
            // Kita gunakan finish() saja supaya kembali ke activity sebelumnya (Dashboard)
            finish()
        }
    }

    private fun setupMenuSwitcher() {
        // Klik Menu Segitiga
        binding.menuSegitiga.setOnClickListener {
            updateUI(isSegitiga = true)
        }

        // Klik Menu Kubus
        binding.menuKubus.setOnClickListener {
            updateUI(isSegitiga = false)
        }
    }

    private fun updateUI(isSegitiga: Boolean) {
        // Menampilkan/Menyembunyikan Layout Input
        binding.layoutSegitiga.visibility = if (isSegitiga) View.VISIBLE else View.GONE
        binding.layoutKubus.visibility = if (isSegitiga) View.GONE else View.VISIBLE

        // Warna Biru Primary Tema kita: #2196F3
        val bluePrimary = Color.parseColor("#2196F3")

        // Update Tampilan Tombol Tab Segitiga
        binding.menuSegitiga.setBackgroundColor(if (isSegitiga) bluePrimary else Color.TRANSPARENT)
        binding.menuSegitiga.setTextColor(if (isSegitiga) Color.WHITE else bluePrimary)

        // Update Tampilan Tombol Tab Kubus
        binding.menuKubus.setBackgroundColor(if (isSegitiga) Color.TRANSPARENT else bluePrimary)
        binding.menuKubus.setTextColor(if (isSegitiga) Color.WHITE else bluePrimary)

        // Reset hasil setiap pindah menu
        binding.txtHasil.text = "0.0"
    }

    private fun setupKalkulator() {
        // Logika Hitung Luas Segitiga
        binding.btnSegitiga.setOnClickListener {
            val a = binding.alas.text.toString()
            val t = binding.tinggi.text.toString()

            if (a.isNotEmpty() && t.isNotEmpty()) {
                val hasil = 0.5 * a.toDouble() * t.toDouble()
                binding.txtHasil.text = "$hasil"
                showToast("Luas Segitiga Berhasil Dihitung")
            } else {
                showToast("Harap isi alas dan tinggi!")
            }
        }

        // Logika Hitung Volume Kubus
        binding.btnKubus.setOnClickListener {
            val s = binding.sisi.text.toString()

            if (s.isNotEmpty()) {
                val hasil = Math.pow(s.toDouble(), 3.0)
                binding.txtHasil.text = "$hasil"
                showToast("Volume Kubus Berhasil Dihitung")
            } else {
                showToast("Harap isi panjang sisi!")
            }
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}