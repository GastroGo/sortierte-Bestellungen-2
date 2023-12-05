package com.gastrogo.sortierte_bestellungen_2.Tisch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gastrogo.sortierte_bestellungen_2.R;

public class TischBestellungen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tisch_bestellungen);

        TextView title = findViewById(R.id.TischBestellungenTitle);

        RecyclerView recyclerView = findViewById(R.id.BestellungenRecyclerView);
        RV_Adapter_Bestellungen adapterBestellungen = new RV_Adapter_Bestellungen();
        recyclerView.setAdapter(adapterBestellungen);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        int tischNr = getIntent().getIntExtra("TableNr", -1);

        title.setText("Tisch " + tischNr);

        Button back = findViewById(R.id.TischBestellungenBack);
        back.setOnClickListener(view -> finish());
    }

}