package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onTicketClick(v: View) {
        val lavadoId = R.id.radioLavado
        val aspiradoId = R.id.radioAspirado
        val lavadoAspiradoId = R.id.radioLavadoAspirado
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
            val checkDetallado = findViewById<CheckBox>(R.id.checkDetallado)
        val checkAspirado = findViewById<CheckBox>(R.id.checkAspirado)
        val editPlaca = findViewById<EditText>(R.id.editPlacas)
        val spinnerMarca = findViewById<Spinner>(R.id.spinnerMarcas)

        val bundle = Bundle()
        when(radioGroup.checkedRadioButtonId) {
            lavadoId -> bundle.putString("selectedOption", "lavado")
            aspiradoId -> bundle.putString("selectedOption", "aspirado")
            lavadoAspiradoId -> bundle.putString("selectedOption", "lavadoAspirado")
        }
        bundle.putBoolean("isDetalladoSelected", checkDetallado.isChecked)
        bundle.putBoolean("isAspiradoSelected", checkAspirado.isChecked)
        bundle.putString("placa", editPlaca.text.toString())
        bundle.putString("marca", spinnerMarca.selectedItem as String)
        // val intento = Intent(this, TicketActivity.class)
        val loIntente = Intent(this, TicketActivity::class.java)
        loIntente.putExtras(bundle)
        startActivity(loIntente)
    }
}
