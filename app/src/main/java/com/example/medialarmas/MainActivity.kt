package com.example.medialarmas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnMedicamentos = findViewById<Button>(R.id.button2)
        btnMedicamentos.setOnClickListener {
            val intent = Intent(this@MainActivity, Medicamentos::class.java)
            startActivity(intent)
        }
        val btnAlarmas = findViewById<Button>(R.id.button_alarmas)
        btnAlarmas.setOnClickListener {
            val intent = Intent(this@MainActivity, Alarmas::class.java)
            startActivity(intent)
        }
    }
}