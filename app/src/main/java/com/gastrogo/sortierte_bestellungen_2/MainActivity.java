package com.gastrogo.sortierte_bestellungen_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    TischeBestellungenListe tischeBestellungenListe = TischeBestellungenListe.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        if (tischeBestellungenListe.tischBestellungenListe.isEmpty()){
            setUpTischBestellungenListe(20);
        }


        // Sort the list based on the 'isBestellungAktiv' flag and 'timer'
        tischeBestellungenListe.sortTischBestellungenListe();

        TB_RecyclerViewAdapter adapter = new TB_RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    private void setUpTischBestellungenListe(int tischAnzahl){
        for (int i = 1; i <= tischAnzahl; i++) {
            int randomTimer = 0;
            boolean isBestellungAktiv = Math.random() < 0.5; // Randomly set isBestellungAktiv to true or false
            if (isBestellungAktiv){
                randomTimer = (int)(Math.random() * 50 + 1);
            }

            tischeBestellungenListe.tischBestellungenListe.add(new TischeBestellungenModel(i, randomTimer, isBestellungAktiv));
        }
    }
}
