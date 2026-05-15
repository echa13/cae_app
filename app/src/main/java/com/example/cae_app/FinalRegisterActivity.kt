package com.example.cae_app.pertemuan_3

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cae_app.databinding.ActivityFinalRegisterBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FinalRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set email otomatis dari halaman sebelumnya (Soal B2)
        val emailTerbawa = intent.getStringExtra("EXTRA_EMAIL")
        binding.etEmailRegis.setText(emailTerbawa)
        binding.etEmailRegis.isEnabled = false // Tidak boleh diubah

        binding.btnSubmitRegis.setOnClickListener {
            val nama = binding.etNamaRegis.text.toString().trim()
            val user = binding.etUserRegis.text.toString().trim()
            val pass = binding.etPassRegis.text.toString().trim()

            // Validasi (Soal B2)
            when {
                nama.isEmpty() || user.isEmpty() || pass.isEmpty() -> Toast.makeText(this, "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()
                pass.length < 6 -> Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
                user.contains(" ") -> Toast.makeText(this, "Username tidak boleh ada spasi", Toast.LENGTH_SHORT).show()
                else -> {
                    // Simpan ke SharedPreferences
                    val sharedPref = getSharedPreferences("UserAccount", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putString("saved_user", user)
                    editor.putString("saved_pass", pass)
                    editor.putString("saved_nama", nama)
                    editor.apply()

                    // Dialog Berhasil
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Registrasi Berhasil")
                        .setMessage("Data Anda telah tersimpan. Silakan login.")
                        .setPositiveButton("Ke Login") { _, _ -> finish() }
                        .show()
                }
            }
        }
    }
}