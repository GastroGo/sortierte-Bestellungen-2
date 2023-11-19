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
        Collections.sort(tischeBestellungenListe.tischBestellungenListe, new Comparator<TischeBestellungenModel>() {
            @Override
            public int compare(TischeBestellungenModel t1, TischeBestellungenModel t2) {
                // Sort by 'isBestellungAktiv' flag in descending order (true comes first)
                int flagComparison = Boolean.compare(t2.getBestellungAktiv(), t1.getBestellungAktiv());

                // If 'isBestellungAktiv' flags are equal, sort by 'timer' in ascending order
                if (flagComparison == 0) {
                    return Integer.compare(t1.getTimer(), t2.getTimer());
                }

                return flagComparison;
            }
        });

        TB_RecyclerViewAdapter adapter = new TB_RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    private void setUpTischBestellungenListe(int tischAnzahl){
        for (int i = 1; i <= tischAnzahl; i++) {
            int randomTimer = (int)(Math.random() * 50 + 1);
            boolean isBestellungAktiv = Math.random() < 0.5; // Randomly set isBestellungAktiv to true or false
            tischeBestellungenListe.tischBestellungenListe.add(new TischeBestellungenModel(i, randomTimer, isBestellungAktiv));
        }
    }
}
