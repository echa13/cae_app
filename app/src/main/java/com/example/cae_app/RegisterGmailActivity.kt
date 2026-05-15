package com.example.cae_app.pertemuan_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cae_app.databinding.ActivityRegisterGmailBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RegisterGmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterGmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterGmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLanjutRegis.setOnClickListener {
            val email = binding.etGmailInput.text.toString().trim()

            if (email.isEmpty()) {
                showError("Email tidak boleh kosong!")
            } else if (!email.endsWith("@gmail.com")) {
                showError("Harus menggunakan domain @gmail.com")
            } else {
                // Berhasil, bawa email ke halaman registrasi (Soal B1 selesai)
                val intent = Intent(this, FinalRegisterActivity::class.java)
                intent.putExtra("EXTRA_EMAIL", email)
                startActivity(intent)
            }
        }
    }

    private fun showError(msg: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Error Validasi")
            .setMessage(msg)
            .setPositiveButton("OK", null)
            .show()
    }
}