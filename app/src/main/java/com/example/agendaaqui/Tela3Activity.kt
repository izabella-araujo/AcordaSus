package com.example.agendaaqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendaaqui.databinding.ActivityTela3Binding

class Tela3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityTela3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTela3Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}