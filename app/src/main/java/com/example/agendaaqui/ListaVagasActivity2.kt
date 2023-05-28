package com.example.agendaaqui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaaqui.com.example.agendaaqui.ConsultaModelo
import com.example.agendaaqui.com.example.agendaaqui.SusAdapter
import com.google.firebase.database.*

class ListaVagasActivity2 : AppCompatActivity() {
    private lateinit var susRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var susList: ArrayList<ConsultaModelo>
    private lateinit var dbRef: DatabaseReference
    private  lateinit var but: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_vagas2)

        susRecyclerView = findViewById(R.id.listVagas)
        susRecyclerView.layoutManager = LinearLayoutManager(this)
        susRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)
        but = findViewById(R.id.BtLista)

        susList = arrayListOf<ConsultaModelo>()

        getEmployeesData()

        but.setOnClickListener {
            val inten = Intent(this, Tela3Activity::class.java)
            startActivity(inten)
        }

    }

    private fun getEmployeesData() {

        susRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Usuario")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                susList.clear()
                if (snapshot.exists()) {
                    for (susSnap in snapshot.children) {
                        val susData = susSnap.getValue(ConsultaModelo::class.java)
                        susList.add(susData!!)
                    }
                    val mAdapter = SusAdapter(susList)
                    susRecyclerView.adapter = mAdapter

                    susRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}
