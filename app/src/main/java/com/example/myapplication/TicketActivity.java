package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        TextView textOutput = findViewById(R.id.txtOutput);
        Bundle paquetito = getIntent().getExtras();
        textOutput.setText(new Gson().toJson(new Ticket(paquetito)));
    }
}

class Ticket {
    String opcion;
    Boolean aspirado;
    Boolean detallado;
    String placa;
    String marca;
    public Ticket(Bundle paquete) {
        opcion = paquete.getString("selectedOption");
        aspirado = paquete.getBoolean("isAspiradoSelected");
        detallado = paquete.getBoolean("isDetalladoSelected");
        placa = paquete.getString("placa");
        marca = paquete.getString("marca");
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Boolean getAspirado() {
        return aspirado;
    }

    public void setAspirado(Boolean aspirado) {
        this.aspirado = aspirado;
    }

    public Boolean getDetallado() {
        return detallado;
    }

    public void setDetallado(Boolean detallado) {
        this.detallado = detallado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}