package com.example.agendaaqui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendaaqui.com.example.agendaaqui.ConsultaModelo
import com.example.agendaaqui.databinding.ActivityCadatrarConsultasBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadatrarConsultasActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCadatrarConsultasBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadatrarConsultasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var CdEspecialidade = binding.CdEspecialidade
        var CdMedico = binding.CdMedico
        var CdHorario = binding.CdHorario
        var CdData = binding.CdData
        var Btcadastrar = binding.Btcadastrar

        dbRef = FirebaseDatabase.getInstance().getReference("Usuario")

       Btcadastrar.setOnClickListener{
           val susEspecialidade = CdEspecialidade.text.toString()
           val susMedico = CdMedico.text.toString()
           val susHorario = CdHorario.text.toString()
           val susData = CdData.text.toString()
           val inten = Intent(this, ListaVagasActivity2::class.java)
           startActivity(inten)

           if(susEspecialidade.isEmpty()){
               CdEspecialidade.error = "Por favor insira uma Especialidade"
           }
           if(susMedico.isEmpty()){
               CdMedico.error = "Por favor insira um Medico"
           }
           if(susHorario.isEmpty()){
               CdHorario.error = "Por favor insira um Horario"
           }
           if(susData.isEmpty()){
               CdData.error = "Por favor insira uma Data"
           }

           val susId = dbRef.push().key!!

           val usuario = ConsultaModelo(susId, susEspecialidade, susMedico, susHorario, susData)

           dbRef.child(susId).setValue(usuario)
               .addOnCompleteListener{
                   Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                   CdEspecialidade.text.clear()
                   CdMedico.text.clear()
                   CdHorario.text.clear()
                   CdData.text.clear()

               }.addOnFailureListener{err ->
                   Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
               }

       }
    }
}