package com.example.cae_app.pertemuan_6

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cae_app.R
import com.example.cae_app.pertemuan_2.HitungActivity
import com.example.cae_app.pertemuan_3.WelcomeActivity
import com.example.cae_app.pertemuan_4.Custom2Activity
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi tombol di dalam Fragment
        val btn1 = view.findViewById<MaterialButton>(R.id.btn1)
        val btn2 = view.findViewById<MaterialButton>(R.id.btn2)
        val btnWelcome = view.findViewById<MaterialButton>(R.id.btnWelcome)
        val btn3 = view.findViewById<MaterialButton>(R.id.btn3)

        btn1.setOnClickListener {
            startActivity(Intent(requireContext(), HitungActivity::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(requireContext(), Custom2Activity::class.java))
        }

        btnWelcome.setOnClickListener {
            val intent = Intent(requireContext(), WelcomeActivity::class.java)
            intent.putExtra("USERNAME", "Nabila") // Bisa ambil dari SharedPrefs jika mau
            startActivity(intent)
        }

        btn3.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }
    }
}