package com.example.cae_app.pertemuan_4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cae_app.databinding.ActivityCustom2Binding

class Custom2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCustom2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustom2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sembunyikan ActionBar atas
        supportActionBar?.hide()

        // Ambil data dari Dashboard (opsional)
        val title = intent.getStringExtra("TITLE") ?: "Kost Aisyah Plaju"
        binding.tvTitle.text = title

        binding.btnOrder.setOnClickListener {
            Toast.makeText(this, "Booking Kost Berhasil dikirim! 🏠", Toast.LENGTH_LONG).show()
        }

        // Tombol Back yang bulat di atas gambar
        binding.btnBackCircle.setOnClickListener {
            finish()
        }
    }
}