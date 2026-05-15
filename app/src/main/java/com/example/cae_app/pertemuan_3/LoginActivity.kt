package com.example.cae_app.pertemuan_3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cae_app.databinding.ActivityLoginBinding
import com.example.cae_app.pertemuan_4.DashboardActivity
import com.example.cae_app.pertemuan_6.SessionManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TOMBOL LOGIN UTAMA
        binding.btnLogin.setOnClickListener {
            val userIn = binding.etUsername.text.toString().trim()
            val passIn = binding.etPassword.text.toString().trim()

            // 1. Ambil data dari SharedPreferences (Data dari FinalRegisterActivity)
            val sharedPref = getSharedPreferences("UserAccount", Context.MODE_PRIVATE)
            val savedUser = sharedPref.getString("saved_user", null)
            val savedPass = sharedPref.getString("saved_pass", null)

            // 2. Cek Kondisi Login (Soal B3)
            // Kondisi: username == password ATAU cocok dengan data SharedPreferences
            if (userIn.isNotEmpty() && (userIn == passIn || (userIn == savedUser && passIn == savedPass))) {

                // Simpan Session
                val session = SessionManager(this)
                session.saveLoginStatus(true, userIn)

                showToast("Selamat Datang, $userIn!")

                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                // 3. Tampilkan Error pakai MaterialAlertDialog (Soal B3)
                MaterialAlertDialogBuilder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username atau password salah. Silakan coba lagi atau daftar akun baru.")
                    .setPositiveButton("Oke", null)
                    .show()
            }
        }

        // TOMBOL REGISTER WITH GMAIL (Soal B1)
        // Pastikan di activity_login.xml kamu sudah tambah button dengan ID: btnRegisterGmail
        binding.btnRegisterGmail.setOnClickListener {
            val intent = Intent(this, RegisterGmailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}