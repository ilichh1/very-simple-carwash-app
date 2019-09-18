package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class TicketActivity extends AppCompatActivity {
    private TextView opcionText;
    private TextView extrasText;
    private TextView placasText;
    private TextView marcaText;
    private TextView ivaText;
    private TextView totalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        /*
        TextView textOutput = findViewById(R.id.txtOutput);
        Bundle paquetito = getIntent().getExtras();
        textOutput.setText(new Gson().toJson(new Ticket(paquetito)));
        */
        opcionText = findViewById(R.id.opcionTxt);
        extrasText = findViewById(R.id.extrasTxt);
        ivaText = findViewById(R.id.ivaTxt);
        totalText = findViewById(R.id.totalTxt);
        placasText = findViewById(R.id.placasTxt);
        marcaText = findViewById(R.id.marcaTxt);

        Ticket ticket = new Ticket(getIntent().getExtras());
        initActivity(ticket);
    }

    private void initActivity(Ticket t) {
        ArrayList<Double> items = new ArrayList<>();

        String selectedOption;
        switch (t.getOpcion()) {
            case "lavadoAspirado":
                selectedOption = "Lavado y aspirado - $ 120.00";
                items.add(60.0);
            break;
            case "aspirado":
                selectedOption = "Aspirado - $ 60.00";
                items.add(60.0);
            break;
            case "lavado": default:
                selectedOption = "Lavado - $ 60.00";
                items.add(60.0);
        }

        String extras = "";

        if (t.getAspirado()) {
            extras += "Aspirado $50";
            items.add(50.0);
        }

        if (t.getDetallado()) {
            if (extras.equals("")) {
                extras = "Detallado $50";
            } else {
                extras += " y Detallado $50";
            }
            items.add(50.0);
        }

        // Calculate tax and total
        double subTotal = 0;
        for (Double item : items) {
            subTotal += item;
        }
        double total = subTotal * 1.16;

        // Set all the values to the layout
        selectedOption = opcionText.getText() + " " + selectedOption;
        opcionText.setText(selectedOption);

        extrasText.setText(extrasText.getText() + " " + extras);

        marcaText.setText(marcaText.getText() + " " + t.getMarca());
        placasText.setText(placasText.getText() + " " + t.getPlaca());
        ivaText.setText(ivaText.getText() + " $" + (subTotal*0.16));
        totalText.setText(totalText.getText() + " $" + total);
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