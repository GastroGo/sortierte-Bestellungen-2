package com.gastrogo.sortierte_bestellungen_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<TischeBestellungenModel> tischBestellungenListe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpTischBestellungenListe(30);

        TB_RecyclerViewAdapter adapter = new TB_RecyclerViewAdapter(this, tischBestellungenListe);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpTischBestellungenListe(int tischAnzahl){
        for (int i = 1; i <= tischAnzahl; i++) {
            int random = (int)(Math.random() * 50 + 1);
            tischBestellungenListe.add(new TischeBestellungenModel(i, random, false));
        }
    }
}