package com.example.agendaaqui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendaaqui.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioNome = binding.tvUsuarioNome
        val nome = intent.getStringExtra("nome")
        usuarioNome.text = nome
        val button = binding.button

        button.setOnClickListener {
            val inten = Intent(this, CadatrarConsultasActivity::class.java)
            startActivity(inten)
        }
    }
}